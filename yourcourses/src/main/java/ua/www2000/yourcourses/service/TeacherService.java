package ua.www2000.yourcourses.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ua.www2000.yourcourses.repository.TeacherRepository;

@Slf4j
@Service
public class TeacherService {
    @Autowired
    private WebApplicationContext applicationContext;

    private TeacherRepository studentsRepository;

    @Autowired
    public StudentService(TeacherRepository studentsRepository) {
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
