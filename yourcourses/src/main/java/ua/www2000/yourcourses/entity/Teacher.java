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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id")
    @NonNull
    private User user;
}
