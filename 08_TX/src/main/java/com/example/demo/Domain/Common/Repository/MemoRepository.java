package com.example.demo.Domain.Common.Repository;


import com.example.demo.Domain.Common.Entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                        //<crud할 대상 entity , primary키 자료형>
public interface MemoRepository extends JpaRepository<Memo,Long> {


}
