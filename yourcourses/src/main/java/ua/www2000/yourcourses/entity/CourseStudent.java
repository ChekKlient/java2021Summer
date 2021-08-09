package ua.www2000.yourcourses.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString

@Entity
public class CourseStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private EducationCourse course;

    @NonNull
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private Student student;

}
