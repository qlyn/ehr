package com.sql.ehr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller  //String需要返回静态页面时，必须用@Controller，而不是@RestController
//@RequestMapping("getPage")   //此时@RequestMapping应该为空与/index.html匹配
public class GetpageController {
    @GetMapping("/getIndex")
    public String getIndex(@RequestParam HashMap<String,Object> map){
        System.out.println("执行index方法:"+map);
        return "/index.html";
    }
    @PostMapping("/index")
    public ModelAndView index(@RequestParam HashMap<String,Object> map){
        ModelAndView modelAndView = new ModelAndView("redirect:/index.html");
        modelAndView.addAllObjects(map);
        System.out.println("被successForwardUrl调用方法:"+map);
        return modelAndView;
    }

}
