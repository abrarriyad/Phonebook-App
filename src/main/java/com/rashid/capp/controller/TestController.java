package com.rashid.capp.controller;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String helloWorld(){
        return "hello"; // /WEb-INF/view/hello.jsp
    }
    
    @RequestMapping("/test/ajax_test")
    public String testPage(){
        return "test"; // /WEb-INF/view/hello.jsp
    }
    
    @RequestMapping("/test/get_time")
    @ResponseBody
    public String getServerTime(){
        Date date = new Date();
    	return date.toString();
    }
}
