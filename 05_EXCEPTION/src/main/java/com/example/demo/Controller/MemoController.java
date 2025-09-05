package com.example.demo.Controller;


import com.example.demo.Domain.Common.Dto.MemoDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
//
//    @ExceptionHandler(Exception.class){
//        public String exception_handler(exception e){
//            log.error("MemoController's Excepton"+e);
//            retrun "memo/error";
//        }
//    }
//




    //(date_time)우리가 직접 관여할 필드항목추가
    @InitBinder
    public void dataBinder(WebDataBinder webDataBinder){
        log.info("MomoController's dataBinder"+webDataBinder);
        webDataBinder.registerCustomEditor(LocalDate.class,"data_test",new DataTestEditor() );
    }

    private static class DataTestEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            log.info("DataTestEditor's setAsText text : ㅔ"+text);
            LocalDate date = null;
            if(text.isEmpty()){
                throws mew NollPorintException("예외발생");
                date = LocalDate.now();
            }else{
                //format 확인 (yyyy#MM#dd)
                text = text.replaceAll("#","-");
                date = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            }
            setValue(date);
        }
    }


    @GetMapping("/add")
    public void add_memo_get() {
        log.info("GET /memo/add");
    }


    @PostMapping("/add")
    public void add_memo_post(@Valid MemoDto dto, BindingResult bindingResult, Model model) {
        log.info("POST /memo/add" + dto);
        log.info("유효성 오류 발생여부 : " + bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                log.info("Error Field : " + error.getField() + "Error Message : " + error.getDefaultMessage());
                model.addAttribute(error.getField(), error.getDefaultMessage());
            }
        }
        //파라미터
        //입력값검증
        //->컨트롤러에서는 데이터검증.
        //서비스   >>Domain.Common.Service
        //뷰로이동
    }


}
