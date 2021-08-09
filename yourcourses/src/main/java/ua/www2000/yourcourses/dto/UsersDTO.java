package ua.www2000.yourcourses.dto;

import lombok.*;
import ua.www2000.yourcourses.entity.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UsersDTO {
private List<User> users;
}
