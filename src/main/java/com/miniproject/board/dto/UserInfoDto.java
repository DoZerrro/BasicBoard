package com.miniproject.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {

    private int userId;
    private int roleId;
    private String roleName;
    private String email;
    private String userName;
    private String password;
}
