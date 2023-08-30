package com.miniproject.board.mapper;

import com.miniproject.board.dto.BoardInfoDto;
import com.miniproject.board.dto.BoardListDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {

    public List<BoardListDto> selectBoardList(int start);
    public int totalBoardCnt();
    public void insertWriter(String title, String content, int userId);
    public BoardInfoDto selectBoardInfo(int seq);
    public void updateBoardInfo(int seq, String title, String content);
    public void updateViewCnt(int seq);
    public void deleteBoardInfo(int seq);
}
