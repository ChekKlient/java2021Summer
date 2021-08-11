package ua.www2000.yourcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.www2000.yourcourses.entity.EducationCourse;

@Repository
public interface EducationCourseRepository extends JpaRepository<EducationCourse, Long> {
}
