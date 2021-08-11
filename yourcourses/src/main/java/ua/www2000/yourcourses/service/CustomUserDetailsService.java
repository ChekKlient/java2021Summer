package ua.www2000.yourcourses.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ua.www2000.yourcourses.dto.UserDTO;
import ua.www2000.yourcourses.dto.UsersDTO;
import ua.www2000.yourcourses.entity.RoleType;
import ua.www2000.yourcourses.entity.User;
import ua.www2000.yourcourses.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private WebApplicationContext applicationContext;

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostConstruct
    public void completeSetup() {
        userRepository = applicationContext.getBean(UserRepository.class);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public UsersDTO getAllUsers() {
        //TODO checking for an empty user list
        return new UsersDTO(userRepository.findAll());
    }

    public Optional<User> findByUserLogin (UserDTO userDTO){
        //TODO check for user availability. password check
        return userRepository.findByEmail(userDTO.getEmail());
    }

    public Optional<User> findByUserLogin (String userName){
        //TODO check for user availability. password check
        return userRepository.findByEmail(userName);
    }

    public void saveNewUser (User user){
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String encryptedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);
        try {
            Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
            if (existingUser.isPresent()) user.setId(existingUser.get().getId());
            userRepository.save(user);
        } catch (Exception ex){
            log.info("{Почтовый адрес уже существует}");
        }

    }

    public void saveExisting (User user){
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        try {
            userRepository.saveExisting(       user.getEmail(),
                    user.getEnabled(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getLocked(),
                    user.getRole());
        } catch (Exception ex){
            log.info("{Почтовый адрес уже существует}");
        }

    }

    public void deleteUserByEMail(UserDTO userDTO) {
        this.userRepository.delete(findByUserLogin(userDTO)
                .orElseThrow(()->new UsernameNotFoundException(userDTO.getEmail())));
    }
}
