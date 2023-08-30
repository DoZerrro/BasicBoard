package com.miniproject.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardListDto {
    private int seq;
    private String title;
    private String content;
    private String name;
    private int viewCnt;
    private LocalDateTime regDate;
}
