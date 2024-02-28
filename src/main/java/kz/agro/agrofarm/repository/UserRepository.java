package kz.agro.agrofarm.repository;

import kz.agro.agrofarm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author inspiredsamat
 * @portfolio <a href="https://inspiredsamat.github.io">Personal portfolio</a>
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
