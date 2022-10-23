package com.example.myfirstcms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.autoconfigure.exception.ForbiddenException;
import com.example.myfirstcms.autoconfigure.exception.ParameterException;
import com.example.myfirstcms.core.utils.LocalUser;
import com.example.myfirstcms.dto.admin.UpdateUserInfoDTO;
import com.example.myfirstcms.dto.user.ChangePasswordDTO;
import com.example.myfirstcms.dto.user.LoginDTO;
import com.example.myfirstcms.dto.user.UpdateInfoDTO;
import com.example.myfirstcms.dto.user.UserDTO;
import com.example.myfirstcms.mapper.UserMapper;
import com.example.myfirstcms.pojo.UserDO;
import com.example.myfirstcms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 根据用户名查询用户信息
     */
    @Override
    public UserDO getUserByUsername(String username) {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserDO::getUsername, username);
        return this.getOne(wrapper);
    }


    @Override
    public UserDO login(LoginDTO loginDTO) {
       return userMapper.login(loginDTO);
    }


    @Override
    public UserDO updateUserInfo(UpdateInfoDTO updateInfoDTO) {
        UserDO userDO = LocalUser.getLocalUser();
        if(StringUtils.hasText(updateInfoDTO.getUsername())){
            boolean exist = this.checkUserExistByUsername(userDO.getUsername());

            if(exist) throw new ForbiddenException(10071);
        }

        if(updateInfoDTO.getUsername() != null){
            userDO.setUsername(updateInfoDTO.getUsername());
        }

        if(updateInfoDTO.getAvatar() != null){
            userDO.setAvatar(updateInfoDTO.getAvatar());
        }

        if(updateInfoDTO.getEmail() != null){
            userDO.setEmail(updateInfoDTO.getEmail());
        }

        if(updateInfoDTO.getNickname() != null){
            userDO.setNickname(updateInfoDTO.getNickname());
        }
       userMapper.updateByUserInfo(userDO);
//        System.out.println(userDO);
        return userDO;
    }


    @Override
    public UserDO queryById(int id) {
        return userMapper.queryById(id);
    }


    public boolean checkUserExistByUsername(String username) {
        int rows = this.baseMapper.selectCountByUsername(username);
        return rows > 0;
    }

    @Override
    public UserDO changeUserPassword(ChangePasswordDTO dto) {
        UserDO user = LocalUser.getLocalUser();
//        boolean valid = userIdentityService.verifyUsernamePassword(user.getId(), user.getUsername(), dto.getOldPassword());

        if((user.getPassword() == dto.getOldPassword())) {
            throw new ParameterException(10032);
        }

        if(dto.getNewPassword() == dto.getConfirmPassword()){
            user.setPassword(dto.getNewPassword());
        }
        this.baseMapper.updateById(user);
        return user;
    }

}
