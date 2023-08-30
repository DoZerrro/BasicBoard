package com.miniproject.board.test.mapper;

import com.miniproject.board.test.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    List<TestDto> selectTest();
}
