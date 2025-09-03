package com.example.demo.Controller;


import com.example.demo.Dto.PersonDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/param")  //기본경로
public class ParameterController {

    @RequestMapping(value = "/p01", method = RequestMethod.GET)
    public void paramHandler_1(@RequestParam(name = "username", required = false) String name) {
        log.info("GET /param/p01" + name);
    }


    @GetMapping("/p02")
    public void paramHandler_2(@RequestParam(name = "username", required = false) String name) {
        log.info("GET /param/p02" + name);
    }


    @PostMapping("/p03")
    public void paramHandler_3(@RequestParam(name = "username", required = false) String name) {
        log.info("POST /param/p03" + name);
    }


    //@ReqeustParam : 동기요청 파라미터 처리 / html form 기반 전달되는 파라미터(JS(form-data가능,JSON Type불가))
    //@RequestBody :  비동기요청 파라미터 처리 / html도 처리가능하지만 json , filedata등 전달되는 파라미터 처리
    // ---> json파일 주고 받을 때만 requestBody,나머지는 RequestParam을 쓴다고 결론냄

    @PostMapping("/p04")
    public void paramHandler_4(@RequestBody String name) {
        log.info("POST /param/p04" + name);
    }

    @PostMapping("/p05")
    public void paramHandler_5(@RequestParam(name = "username", required = false, defaultValue = "홍길동") String name) {
        log.info("POST /param/p05" + name);
    }

    //defaultValue = 파라미터를 지정하지 않더라도 기본적으로 들어가는 값

    @GetMapping("/p06")
    public void paramHandler_6(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String addr
    ) {
        log.info("GET /param/p06" + name + " " + age + " " + addr);
    }
//WEB BINDER : 유효성 검증에 효과적이고 형변환이 가능


    @GetMapping("/p07")
    public void paramHandler_7(PersonDto dto) {
        log.info("GET /param/p07" + dto);
    }

    //ModelAttribute : 모델이라는 단위객체에 속성을 넣는다는 어노테이션

    @GetMapping("/p08/{name}/{age}/{addr}")
    public void paramHandler_8(
            @PathVariable(value = "name") String name,
            @PathVariable(value = "age") int age,
            @PathVariable(value = "addr") String addr
    ) {
        log.info("GET /param/p08" + name + " " + age + " " + addr);
    }

    //경로 기반으로 파라미터를 전달하는 경우도 있음


    //<DTO에서 받아오기>
    @GetMapping("/p09/{name}/{age}/{addr}")
    public void paramHandler_9(PersonDto dto) {
        log.info("GET /param/p09" + dto);
    }


    @GetMapping("/page1")
    public void page1(PersonDto dto, Model model) {
        log.info("GET /param/page1" + dto);

        // 01파라미터받기
        // 02 유효성검사
        // 03서비스(비즈니스로직)실행
        model.addAttribute("isLogin", true);
        model.addAttribute("dto", dto);
        // 04뷰 전송
    }

    @GetMapping("/page2/{name}/{age}/{addr}")
    public ModelAndView page2_handler(PersonDto dto) {
        log.info("GET /param/page2" + dto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dto", dto);
        modelAndView.setViewName("param/page2");
        return modelAndView;
    }


    // <서블릿기반인지 확인하기>
    @GetMapping("/page3")
    public void page3_handler(HttpServletRequest request) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String addr = request.getParameter("addr");
        log.info("GET /param/page3" + name + " " + age + " " + addr);

        PersonDto dto = new PersonDto(name, age, addr);
        request.setAttribute("dto", dto);  //forwarding 방식
//        HttpSession session = request.getSession();
//        session.setAttribute("dto",dto);
    }

    @GetMapping("/page4")
    public void page4_handler(@RequestParam Map<String, Object> param) { //Object로하면 파라미터 뭐든 다 받을 수 있음

        log.info("GET /param/page4" + param);

    }
    //Controller -> service -> dao
    //-------------------------->dto 모든단계에 전반적으로 활용됨


    //---------
    //FORWARD
    //---------
    @GetMapping("/forward/init")
    public String forward_init_handler(Model model) {
        log.info("GET /param/forward/init");
        model.addAttribute("init", "init_value");
        return "forward:/param/forward/step1";
    }

    @GetMapping("/forward/step1")
    public String forward_step1_handler(Model model) {
        log.info("GET /param/forward/step1");
        model.addAttribute("step1", "step_value");
        return "forward:/param/forward/step2";
    }

    @GetMapping("/forward/step2")
    public void forward_step2_handler() {
        log.info("GET /param/forward/step2");
    }


    //----------
    //REDIRECT
    //----------

    @GetMapping("/redirect/init")
    public String redirect_init_handler(Model model, RedirectAttributes redirectAttributes) {
        log.info("GET /param/redirect/init");
        model.addAttribute("init","init_value"); //쿼리스터링으로 전달
        redirectAttributes.addFlashAttribute("redirect_init2","redirect_value2");
        redirectAttributes.addAttribute("redirect_init","redirect_value");

        return"redirect:/param/redirect/step1";
    }

    @GetMapping("/redirect/step1")
    public void redirect_step1_handler(Model model,@RequestParam String redirect_init) {
        log.info("GET /param/redirect/step1"+redirect_init);
        model.addAttribute("step1","step1_value");
//        return "redirect:/param/redirect/step2";
    }

    @GetMapping("/redirect/step2")
    public void redirect_step2_handler() {
        log.info("GET /param/redirect/step2");
    }











}
//required = false : 파라미터를 받는게 필수는 아니어도 되고 콘솔에는 null값으로 표시됨
//http://localhost:8091/param/p01?   : ? 쿼리스트링


//@RequestMapping("")
//public void paramHandler_1(){
// log.info("");}