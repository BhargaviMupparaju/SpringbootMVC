package com.example.springbootmvc;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

   @RequestMapping("/")
    public String home(){
        return "index.jsp";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest req){  // HttpsServletRequest object is available in Tomcat

       int i= Integer.parseInt(req.getParameter("num1"));
       int j= Integer.parseInt(req.getParameter("num2"));

        int num3= i+j;
//        we need to send the num3 to the result.jsp

        HttpSession session = req.getSession();
        session.setAttribute("num3",num3);  // whatever the name we give here we have to use the same name in result.jsp
        return "result.jsp";
    }
}
