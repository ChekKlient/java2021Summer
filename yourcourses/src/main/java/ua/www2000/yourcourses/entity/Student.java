package ua.www2000.yourcourses.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id")
    @NonNull
    private User user;

    @OneToMany(mappedBy = "student")
    private List<CourseStudent> courseStudents;

}
