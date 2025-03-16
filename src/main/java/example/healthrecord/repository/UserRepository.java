package example.healthrecord.repository;

import example.healthrecord.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
        boolean existsByUserEmail(String userEmail);
}
