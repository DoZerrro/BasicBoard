package com.miniproject.board.service;

import com.miniproject.board.dto.UserInfoDto;
import com.miniproject.board.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public UserInfoDto login(String email) {
        return userMapper.selectUserInfo(email);
    }

    public void addUserInfo(String email, String name, String password) {
        userMapper.insertUserInfo(email, name, password);
    }

    public void addUserRole(int userId, int roleId) {
        userMapper.insertUserRole(userId, roleId);
    }

    public boolean checkEmail(String email) {
        List<String> emailList = userMapper.selectEmailList();
        for(String str : emailList) {
            if(str.equals(email)) {
                return true;
            }
        }
        return false;
    }
}
