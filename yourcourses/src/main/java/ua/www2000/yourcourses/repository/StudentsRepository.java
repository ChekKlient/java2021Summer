package ua.www2000.yourcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.www2000.yourcourses.entity.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
}
