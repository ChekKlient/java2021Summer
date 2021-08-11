package ua.www2000.yourcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.www2000.yourcourses.entity.RoleType;
import ua.www2000.yourcourses.entity.User;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("UPDATE User u SET u.lastLogin=:lastLogin WHERE u.email = ?#{ principal?.username }")
    @Modifying
    @Transactional
    void updateLastLogin(@Param("lastLogin") Date lastLogin);

    Optional<User> findByRole(RoleType role);

    @Query("UPDATE User u SET u.enabled=:enabled, firstName=:first_name, lastName=:last_name, locked=:locked, role=:role  WHERE u.email = :email")
    @Modifying
    @Transactional
    void saveExisting(@Param("email") String email,
                      @Param("enabled") Boolean enabled,
                      @Param("first_name") String firstName,
                      @Param("last_name") String lastName,
                      @Param("locked") Boolean locked,
                      @Param("role") RoleType role);

}