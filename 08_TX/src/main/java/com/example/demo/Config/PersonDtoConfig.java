package com.example.demo.Config;


import com.example.demo.Dto.PersonDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonDtoConfig {

    @Bean
    public PersonDto person03 () {
        return PersonDto.builder()
                .name("지원")
                .age(20)
                .addr("대구")
                .build();
    }

    @Bean(name="personBean")
    public PersonDto person04 () {
        return PersonDto.builder()
                .name("버즈")
                .age(25)
                .addr("대구")
                .build();

    }

}
