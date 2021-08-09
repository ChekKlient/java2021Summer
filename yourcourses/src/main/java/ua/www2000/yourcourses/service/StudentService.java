package ua.www2000.yourcourses.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ua.www2000.yourcourses.entity.Student;
import ua.www2000.yourcourses.repository.StudentsRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentService {
    @Autowired
    private WebApplicationContext applicationContext;

    private StudentsRepository studentsRepository;

    @Autowired
    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @PostConstruct
    public void completeSetup() {
        studentsRepository = applicationContext.getBean(StudentsRepository.class);
    }

    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Student saveStudent(Student topic) {
        return studentsRepository.save(topic);
    }

    public void deleteStudentById(Long id) {
        studentsRepository.deleteById(id);
    }

    public Optional<Student> findById(Long id) {
        return studentsRepository.findById(id);
    }
}
