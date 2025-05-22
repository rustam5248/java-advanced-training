package uz.rustam.training.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rustam.training.springboot_module.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
