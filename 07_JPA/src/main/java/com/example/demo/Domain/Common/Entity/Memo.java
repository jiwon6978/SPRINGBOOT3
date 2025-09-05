package com.example.demo.Domain.Common.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name="memo")
@AllArgsConstructor
@Builder
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id값 입력없이 자동으로 생성

    private Long id;
    @Column(length = 1024)
    private String text;
    @Column(length = 100,nullable = false)//false : 무조건데이터필요
    private String writer;
    private LocalDateTime createAt;

}
