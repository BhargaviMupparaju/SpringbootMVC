package com.example.springbootmvc;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

   @RequestMapping("/")
    public String home(){
        return "index.jsp";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j,HttpSession session){  // Here we are getting param values from the url

// We reduced the no of lines with the requestparam
        int num3= i+j;
//        we need to send the num3 to the result.jsp
        session.setAttribute("num3",num3);  // whatever the name we give here we have to use the same name in result.jsp
        return "result.jsp";
    }
}
