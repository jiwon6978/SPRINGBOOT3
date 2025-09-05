package com.example.demo.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/except")
public class ExceptionTestController {

    @ExceptionHandler(Exception.class)
    public String exception_handler(Exception e, Model model){
        model.addAttribute("ex",e);
        return "except/error";
    }



    //지역예외처리
//    @ExceptionHandler(FileNotFoundException.class)
//    public String exception_handler(Exception e, Model model){
//        model.addAttribute("ex",e);
//        log.error("error : "+e);
//        return "/except";
//    }
//
//    @ExceptionHandler(ArithmeticException.class)
//    public void exception_handler(Exception e){
//        log.error("error : "+e);
//        return "/except/error";
//    }
//
//
//
//    @GetMapping("/ex1")
//    public void ex1() throws FileNotFoundException{
//        log.info("GET /except/ex1");
//        throw new FileNotFoundException("파일을 확인할 수 없습니다.");
//
//    }
//
//
//    @GetMapping("/ex2/{num}/{div}")
//    public String ex2(
//            @PathVariable int num,
//            @PathVariable int div,
//            Model model
//    ) throws ArithmeticException
//    {
//        log.info("GET /except/ex2"+(num/div));
//        model.addAttribute("result",(num/div));
//        return"except/ex2";
//    }
//
//    @GetMapping("/ex3")
//    public void ex3(){
//        log.info("GET /except/ex3");
//    }






}
//클라이언트의 잘못된 요청 - 400번대 , 페이지 내의 문제 -500번대