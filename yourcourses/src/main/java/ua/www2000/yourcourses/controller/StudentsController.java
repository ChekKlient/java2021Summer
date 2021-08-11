package ua.www2000.yourcourses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.www2000.yourcourses.entity.Student;
import ua.www2000.yourcourses.service.StudentService;

@Controller
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String viewStudents(Model model){
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "/students";
    }

}
