package ua.www2000.yourcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString

@Entity
public class EducationCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    @NonNull
    private Topic topic;

    @Column(name = "description", nullable = false)
    @NonNull
    private String description;

    @Column(name = "start_date", nullable = false)
    @NonNull
    private LocalDate startDate;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private Teacher teacher;

    @Column(name = "duration")
    private Integer duration;

    @OneToMany(mappedBy = "course")
    private List<CourseStudent> courseStudents;


}
