package com.miniproject.board.service;

import com.miniproject.board.dto.BoardInfoDto;
import com.miniproject.board.dto.BoardListDto;
import com.miniproject.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<BoardListDto> selectBoardList(int page) {
        int start = (page - 1) * 10;
        return boardMapper.selectBoardList(start);
    }

    public int totalBoardCnt() {
        return boardMapper.totalBoardCnt();
    }

    public void insertWriter(String title, String content, int userId) {
        boardMapper.insertWriter(title, content, userId);
    }

    public BoardInfoDto selectBoardInfo(int seq) {
        boardMapper.updateViewCnt(seq);
        return boardMapper.selectBoardInfo(seq);
    }

    public void updateBoardInfo(int seq, String title, String content) {
        boardMapper.updateBoardInfo(seq, title, content);
    }

    public void deleteBoardInfo(int seq) {
        boardMapper.deleteBoardInfo(seq);
    }
}
