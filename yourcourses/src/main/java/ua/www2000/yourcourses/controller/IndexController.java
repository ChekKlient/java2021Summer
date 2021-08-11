package ua.www2000.yourcourses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("/")
    public String home1() {
        return "/index";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

/*    @GetMapping("/sign-in")
    public String signIn() {
        return "/sign-in";
    }
*/
    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}