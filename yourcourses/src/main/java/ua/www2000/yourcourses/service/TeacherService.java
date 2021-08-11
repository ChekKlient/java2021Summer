package ua.www2000.yourcourses.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ua.www2000.yourcourses.entity.Teacher;
import ua.www2000.yourcourses.repository.TeacherRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TeacherService {
    @Autowired
    private WebApplicationContext applicationContext;

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostConstruct
    public void completeSetup() {
        teacherRepository = applicationContext.getBean(TeacherRepository.class);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher saveTeacher(Teacher topic) {
        return teacherRepository.save(topic);
    }

    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }
}
