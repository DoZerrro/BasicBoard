package com.miniproject.board.controller;

import com.miniproject.board.dto.BoardInfoDto;
import com.miniproject.board.dto.BoardListDto;
import com.miniproject.board.dto.UserInfoDto;
import com.miniproject.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/")
    public String getBoardList(
            @RequestParam(name="page", defaultValue = "1") int page
            , Model model
            , HttpSession httpSession
    ) {
        UserInfoDto userInfo = (UserInfoDto)httpSession.getAttribute("userInfo");
        model.addAttribute("userInfo", userInfo);

        int total = boardService.totalBoardCnt();
        List<BoardListDto> boardList = boardService.selectBoardList(page);
        int pageCnt = total / 10;
        if(total % 10 > 0) pageCnt++;

        model.addAttribute("boardList", boardList);
        model.addAttribute("pageCnt", pageCnt);
        model.addAttribute("currentPage", page);
        model.addAttribute("total", total);
        return "main";
    }

    @GetMapping("/writerForm")
    public String writerForm(HttpSession httpSession, Model model) {
        UserInfoDto userInfo = (UserInfoDto) httpSession.getAttribute("userInfo");
        if(userInfo == null) {
            return "redirect:/loginForm";
        }
        model.addAttribute("userInfo", userInfo);
        
        return "writerForm";
    }

    @PostMapping("/write")
    public String write(
            @RequestParam("title") String title
            , @RequestParam("content") String content
            , HttpSession httpSession
    ) {
        UserInfoDto userInfoDto = (UserInfoDto) httpSession.getAttribute("userInfo");
        boardService.insertWriter(title, content, userInfoDto.getUserId());

        return "redirect:/";
    }

    @GetMapping("/board")
    public String boardDetail(
            @RequestParam("id") int seq
            , HttpSession httpSession
            , Model model) {
        BoardInfoDto boardInfo = boardService.selectBoardInfo(seq);
        model.addAttribute("boardInfo", boardInfo);

        UserInfoDto userInfo = (UserInfoDto) httpSession.getAttribute("userInfo");
        model.addAttribute("userInfo", userInfo);
        return "board";
    }

    @GetMapping("/updateForm")
    public String updateForm(
            @RequestParam("id") int seq
            , Model model
    ) {
        BoardInfoDto boardInfo = boardService.selectBoardInfo(seq);
        model.addAttribute("boardInfo", boardInfo);
        return "updateForm";
    }

    @PostMapping("/update")
    public String update(
            @RequestParam("seq") int seq
            ,@RequestParam("title") String title
            , @RequestParam("content") String content
    ) {
        boardService.updateBoardInfo(seq, title, content);

        return "redirect:/board/?id=" + seq;
    }

    @GetMapping("/delete")
    public String delete(
            @RequestParam("id") int seq
    ) {
        boardService.deleteBoardInfo(seq);
        return "redirect:/";
    }

}
