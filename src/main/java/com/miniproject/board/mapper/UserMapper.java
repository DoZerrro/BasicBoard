package com.miniproject.board.mapper;

import com.miniproject.board.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    public UserInfoDto selectUserInfo(String email);
    public void insertUserInfo(String email, String name, String password);
    public void insertUserRole(int userId, int roleId);
    public List<String> selectEmailList();
}
