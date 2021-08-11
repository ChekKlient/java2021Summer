package ua.www2000.yourcourses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.www2000.yourcourses.entity.EducationCourse;
import ua.www2000.yourcourses.entity.EducationCourse;
import ua.www2000.yourcourses.service.EducationCourseService;
import ua.www2000.yourcourses.service.EducationCourseService;

import javax.validation.Valid;

@Controller
public class EducationCourseController {
    @Autowired
    private EducationCourseService educationCourseService;

    @GetMapping("/education_courses")
    public String viewEducationCourses(Model model){
        model.addAttribute("listEducationCourses", educationCourseService.getAllEducationCourses());
        return "/education_courses";

    }

    @GetMapping("/education_courses-add")
    public String showAddEducationCourse(Model model) {
        EducationCourse educationCourse = new EducationCourse();
        model.addAttribute("educationCourse", educationCourse);
        return "education_courses-add";
    }

    @PostMapping("/education_courses-add")
    public String addEducationCourse(@Valid EducationCourse educationCourse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "education_courses-add";
        }

        educationCourseService.saveEducationCourse(educationCourse);
        return "redirect:/education_courses";
    }

    @GetMapping("/education_courses-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        EducationCourse educationCourse = educationCourseService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id:" + id));
        model.addAttribute("educationCourse", educationCourse);
        return "education_courses-edit";
    }

    @PostMapping("/education_courses-edit")
    public String updateEducationCourse(@Valid EducationCourse educationCourse,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "education_courses-edit";
        }

        educationCourseService.saveEducationCourse(educationCourse);
        return "redirect:/education_courses";
    }

    @GetMapping("/education_courses-delete/{id}")
    public String deleteEducationCourse(@PathVariable(value = "id") Long id) {

        // call delete employee method
        educationCourseService.deleteEducationCourseById(id);
        return "redirect:/education_courses";
    }

}
