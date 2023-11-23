package com.yowayimono.order_food.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.core.utils.EncryptionUtils;

import com.yowayimono.order_food.core.utils.RedisUtils;
import com.yowayimono.order_food.enitiy.User;
import com.yowayimono.order_food.mapper.UserMapper;

import com.yowayimono.order_food.service.UserService;
import com.yowayimono.order_food.vo.*;
import lombok.extern.slf4j.Slf4j;
import okio.FileMetadata;
import org.apache.ibatis.annotations.Select;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.yowayimono.order_food.core.validator.Validator.*;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisUtils redisutils;

    //@Value("${File.uploadPath}")
    private String uploadPath = "/upload";
    ModelMapper modelmapper;
    public UserServiceImpl() {
        modelmapper = new ModelMapper();
    }
    @Override
    public Result Register(UserVo user) {
        // 查询数据库，检查用户名是否已存在
        log.warn(user.toString());
        if (userMapper.findUserByName(user.getUsername()) != null) {
            return Result.fail("用户名已存在");
        }

        if (!isValidUsername(user.getUsername())) {
            return Result.fail("用户名格式不正确");
        }

        if (!isValidPassword(user.getPassword())) {
            return Result.fail("密码格式不正确");
        }

        if (!isValidPhoneNumber(user.getMobile())) {
            return Result.fail("电话号码格式不正确");
        }

        // 执行注册逻辑
        AddrUser(user);

        return Result.success(user.getUsername());
    }


    @Override
    public Result Login(LoginVo user) {
        User u =  userMapper.findUserByName(user.getUsername());
        log.warn(u.toString());
        if(u==null){
            return Result.fail(666,"用户不存在！");
        }

        if(!EncryptionUtils.checkPassWord(user.getPassword(),u.getPassword())) {
            return Result.fail(444,"密码错误！");
        }

        if(!u.getRole().equals("user")) {
            Result.fail(2333,"非用户账号！");
        }

        if(redisutils.get(u.getId().toString())!=null){
            // 判断是否已经登录过，这里不判断很可
            return Result.fail(444,"已经登陆过了亲~");
        }

        UUID id = UUID.randomUUID();

        String token = "token_"+id.toString();

        redisutils.setEx( token,u.getId().toString(),30, TimeUnit.MINUTES);

        redisutils.setEx( u.getId().toString(),token,30, TimeUnit.MINUTES);

        return Result.success(new TokenAndUser(u.getId(),token,u.getUsername()));
    }



    private void AddrUser(UserVo user) {
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(EncryptionUtils.sha256(user.getPassword()));
        u.setMobile(user.getMobile());
        u.setRole("user"); //
        userMapper.insert(u);
    }


 

    @Override
    public  Result findUser(PageSelect page){
        List<User> userlist = userMapper.findUsers(page.getPagesize(), page.getOffect());

        List<UserInfo> result = new ArrayList<>();
        for (User user : userlist) {
            UserInfo userInfo = modelmapper.map(user, UserInfo.class);
            result.add(userInfo);
        }

        return Result.success(result);
    }





    @Override
    public Result updateUser(UserInfo user) {
        String username = user.getUsername(); // 获取用户ID
        // 构建更新的字段映射
        Map<String, Object> updateFields = new HashMap<>();

        // 使用反射获取所有字段
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(user);
                if (value != null) {
                    updateFields.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // 更新用户信息，including avatar
        if (!updateFields.isEmpty()) {
            // 构建更新条件
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("username", username);

            // Handle avatar update
            if (updateFields.containsKey("avatarFile")) {
                MultipartFile avatarFile = (MultipartFile) updateFields.get("avatarFile");

                try {
                    // Save the avatar file
                    String newFileName = saveAvatar(avatarFile);
                    // Update the user's avatar field
                    updateFields.put("avatar", newFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                    return Result.fail("更新头像失败！");
                }
            }

            // 执行更新操作
            User u = userMapper.findUserByName(username);
            u = modelmapper.map(user, u.getClass());
            userMapper.update(u, updateWrapper);
        }
        return Result.success("更新成功！");
    }

    // Save avatar method
    private String saveAvatar(MultipartFile file) throws IOException {

        String newFileName = null;
        if (file != null && !file.isEmpty()) {
            // 存文件
            String oldFileName = file.getOriginalFilename();
            String randomStr = UUID.randomUUID().toString();
            newFileName = randomStr + oldFileName.substring(oldFileName.lastIndexOf("."));
            String filePath = uploadPath + File.separator + "avatar" + File.separator + newFileName;
            File destFile = new File(filePath);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            file.transferTo(destFile);
        }
        return newFileName;




    }


    /*

    @Override
    public Result updateUser(UserInfo user) {
        String username = user.getUsername(); // 获取用户ID
        // 构建更新的字段映射
        Map<String, Object> updateFields = new HashMap<>();

        // 使用反射获取所有字段
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(user);
                if (value != null) {
                    updateFields.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // 更新用户信息
        if (!updateFields.isEmpty()) {
            // 构建更新条件
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("username", username);
            // 执行更新操作
            User u =userMapper.findUserByName(username);

            u=modelmapper.map(user,u.getClass());
            userMapper.update(u, updateWrapper);
        }
        return Result.success("更新成功！");
    }
*/
}
