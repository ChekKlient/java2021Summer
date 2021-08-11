package ua.www2000.yourcourses.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.www2000.yourcourses.dto.UserDTO;
import ua.www2000.yourcourses.dto.UsersDTO;
import ua.www2000.yourcourses.entity.User;
import ua.www2000.yourcourses.service.CustomUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@AllArgsConstructor
public class LoginFormController {

    private final CustomUserDetailsService userService;

    @GetMapping("/sign-in")
    String signIn() {

        return "sign-in";
    }

    @GetMapping("/sign-up")
    String signUpPage(User user) {

        return "sign-up";
    }

    @PostMapping("/sign-up")
    String signUp(User user) {

        userService.saveNewUser(user);

        return "redirect:/sign-in";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
 }
