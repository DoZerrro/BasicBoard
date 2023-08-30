package com.miniproject.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardInfoDto {

    private int seq;
    private int userId;
    private String name;
    private String title;
    private String content;
    private int viewCnt;
    private LocalDateTime regDate;
}
