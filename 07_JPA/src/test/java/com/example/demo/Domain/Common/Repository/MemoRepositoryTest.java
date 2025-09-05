package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//내용 insert
@SpringBootTest
class MemoRepositoryTest {

    @Autowired
    private MemoRepository memoRepository;
    @Test
    public void t1(){Memo memo = new Memo(null,"내용1","test@tet.com", LocalDateTime.now());
    memoRepository.save(memo);
    System.out.println("ID : "+memo.getId());

    }
    //내용 수정
    @Test
    public void t2() {
        Memo memo = new Memo(1L, "수정1", "test@tet.com", LocalDateTime.now());
        memoRepository.save(memo);
        System.out.println("ID : " + memo.getId());


    }

    //내용 삭제
    @Test
    public void t3(){
        memoRepository.deleteById(2L);

    }

    //내용 조회 (단건)
    @Test
    public void t4(){
      Optional<Memo> memoOptional =  memoRepository.findById(3L);

      //또는 이런 방법
      if(memoOptional.isPresent()){
          Memo memo = memoOptional.get();
          System.out.println(memo);}
    }

    //전체 조회
    @Test
    public void t5(){
        List<Memo> list = memoRepository.findAll();
        list.forEach(System.out::println);  //(el)->{System.out.println(el)} 줄인거
    }
    
}

