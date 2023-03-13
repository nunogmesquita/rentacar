package academy.mindswap.rentacar.repository;

import academy.mindswap.rentacar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT c FROM User c WHERE c.id= :userId")
    Optional<User> findUserById(@Param("userId") Long userId);
}