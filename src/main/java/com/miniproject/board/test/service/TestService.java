package com.miniproject.board.test.service;

import com.miniproject.board.test.dto.TestDto;
import com.miniproject.board.test.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public List<TestDto> selectTest() {
        return testMapper.selectTest();
    }
}
