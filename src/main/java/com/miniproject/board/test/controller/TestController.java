package com.miniproject.board.test.controller;

import com.miniproject.board.test.dto.TestDto;
import com.miniproject.board.test.service.TestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/list")
    public List<TestDto> getTest() {
        return testService.selectTest();
    }
}
