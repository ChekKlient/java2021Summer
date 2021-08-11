package ua.www2000.yourcourses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.www2000.yourcourses.dto.UserDTO;
import ua.www2000.yourcourses.entity.User;
import ua.www2000.yourcourses.service.CustomUserDetailsService;

import javax.validation.Valid;

@Controller
public class UsersController {
    @Autowired
    private CustomUserDetailsService userService;

    @GetMapping("/users")
    public String viewUsers(Model model){
        model.addAttribute("listUsers", userService.getAllUsers().getUsers());
        return "/users";

    }

    @GetMapping("/users-add")
    public String showAddUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users-add";
    }

    @PostMapping("/users-add")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users-add";
        }

        userService.saveNewUser(user);
        return "redirect:/";
    }

    @GetMapping("/users-edit/{userName}")
    public String showUpdateForm(@PathVariable("userName") String userName, Model model) {
        User user = userService.findByUserLogin(userName)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user name:" + userName));
        user.setPassword("");

        model.addAttribute("user", user);
        return "users-edit";
    }

    @PostMapping("/users-edit/{userName}")
    public String updateUser(@PathVariable("userName") String userName, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
 //           user.setId(id);
            return "users-edit";
        }

        if (user.getPassword().equals(""))
            userService.saveExisting(user);
        else
            userService.saveNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users-delete/{userName}")
    public String deleteUser(@PathVariable(value = "userName") String userName) {
        userService.deleteUserByEMail(new UserDTO(userName,""));
        return "redirect:/users";
    }

}
