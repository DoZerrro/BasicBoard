package com.miniproject.board.mapper;

import com.miniproject.board.test.dto.TestDto;
import com.miniproject.board.test.mapper.TestMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
class TestMapperTest {

    @Autowired
    TestMapper testMapper;

    @Test
    @DisplayName("code test")
    void selectTest() {
        List<TestDto> list = testMapper.selectTest();
        for (TestDto testDto : list) {
            log.info("------------------------------" + testDto.getSeq());
            log.info("------------------------------" + testDto.getName());
            log.info("------------------------------" + testDto.getContent());
        }
    }
  
}