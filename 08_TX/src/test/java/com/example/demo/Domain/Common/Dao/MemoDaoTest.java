package com.example.demo.Domain.Common.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MemoDaoTest {

    @Autowired
    private MemoDao memoDao;

//    @Test
//    public void t1()throws SQLException{
//        memoDao.insert(new MemoDto(20L,"내용","user111@naver.com",LocalDateTime.now()));
//
//    }


}