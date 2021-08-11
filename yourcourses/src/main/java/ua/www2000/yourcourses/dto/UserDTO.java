package ua.www2000.yourcourses.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class UserDTO {
    @NonNull
    private String email;
    private String firstName;
    private String lastName;
    @NonNull
    private String password;
}
