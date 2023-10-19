package com.example.springbootmvc;


import com.example.model.Alien;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @ModelAttribute
    public void modelData(Model m){

        m.addAttribute("name","sai");

    }

    // Here ModelAttribute will create a model object before calling any other request mapping.
//    so after wherever the name is required in other requestmapping the name attribute is available.
//    Model is used to pass the data to from controller to the view.It will help to carry the data to the view.
//    In the above example it sends the value sai to the attribute name which is used in the name.

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j) {  // Here we are getting param values from the url

        int num3 = i + j;
        ModelAndView mv = new ModelAndView();
        //ModelAndView holds the data that needs to be sent to the view.

        mv.addObject("num3", num3); // we can add the attribute which needs to be send.

//        mv.setViewName("result.jsp"); //specifies the view that should be rendered.
//        Instead of giving the file name directly we can give the filename prefix by placing the jsp files in view folder
//        and set the path in application properties file.

        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute Alien a){
        // ModelAttribute helps to add the data into the model instead adding them with RequestParam

        return "result";

    }
}
