package com.example.demo.Domain.Common.Dao;

import com.example.demo.Domain.Common.Dto.MemoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemoDaoTest {

    @Autowired
    private MemoDao memoDao;

    @Test
    public void t1()throws SQLException{
        memoDao.insert(new MemoDto(20L,"내용","user111@naver.com",LocalDateTime.now()));

    }


}