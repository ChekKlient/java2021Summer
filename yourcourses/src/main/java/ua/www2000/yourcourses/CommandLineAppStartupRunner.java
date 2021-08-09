package ua.www2000.yourcourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import sun.util.calendar.LocalGregorianCalendar;
import ua.www2000.yourcourses.dto.UserDTO;
import ua.www2000.yourcourses.entity.RoleType;
import ua.www2000.yourcourses.entity.User;
import ua.www2000.yourcourses.repository.UserRepository;
import ua.www2000.yourcourses.service.CustomUserDetailsService;

import java.sql.Date;
import java.util.Optional;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String...args) {
        Optional<User> user= userRepository.findByEmail("admin@test.test");
        if (user.isPresent())
            if (user.get().getRole() != RoleType.ROLE_ADMIN) userRepository.delete(user.get());


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User userAdmin = userRepository.findByRole(RoleType.ROLE_ADMIN).orElse(new User("admin","admin", "admin@test.test", RoleType.ROLE_ADMIN, passwordEncoder.encode("password")));

//        if (!userAdmin.isEnabled()) {
            userAdmin.setEnabled(true);
            userRepository.save(userAdmin);
//        }

    }
}
