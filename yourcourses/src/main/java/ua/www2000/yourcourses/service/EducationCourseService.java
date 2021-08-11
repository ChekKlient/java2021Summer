package ua.www2000.yourcourses.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ua.www2000.yourcourses.entity.EducationCourse;
import ua.www2000.yourcourses.repository.EducationCourseRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EducationCourseService {
    @Autowired
    private WebApplicationContext applicationContext;

    private EducationCourseRepository educationCourseRepository;

    @Autowired
    public EducationCourseService(EducationCourseRepository educationCourseRepository) {
        this.educationCourseRepository = educationCourseRepository;
    }

    @PostConstruct
    public void completeSetup() {
        educationCourseRepository = applicationContext.getBean(EducationCourseRepository.class);
    }

    public List<EducationCourse> getAllEducationCourses() {
        return educationCourseRepository.findAll();
    }

    public EducationCourse saveEducationCourse(EducationCourse educationCourse) {
        return educationCourseRepository.save(educationCourse);
    }

    public void deleteEducationCourseById(Long id) {
        educationCourseRepository.deleteById(id);
    }

    public Optional<EducationCourse> findById(Long id) {
        return educationCourseRepository.findById(id);
    }
}
