package se.lexicon.marketplaceapi.repository;



import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.stereotype.Repository;
import se.lexicon.marketplaceapi.model.User;


import java.util.Optional;

@SpringBootApplication
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

    User save(User user);
}




