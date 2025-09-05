package com.example.demo.Domain.Common.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoDto {

//    @Min(value = 10 , message="ID는 10이상의 값부터 시작합니다.")
//    @Max(value = 65535,message="ID의 최대 숫자는 65535입니다.")
//    @NotNull(message = "필수입력항목입니다.")
//    private Long id;

    @NotBlank(message="TEXT는 필수항목입니다.")
    private String text;

    @NotNull(message="작성자를 입력하세요.")
    @Email(message="example@example.com 형식으로 입력하세요")
    private String writer;

//    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
//    @NotNull(message="날짜 정보를 선택하세요")
//    @Future(message="오늘날짜기준 이후날짜를 입력하세요")
//    private LocalDateTime createAt;

//    private LocalDate data_test;
}
