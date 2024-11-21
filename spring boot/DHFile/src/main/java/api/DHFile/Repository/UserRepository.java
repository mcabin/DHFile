package api.DHFile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.DHFile.Entities.User;
import java.util.Optional;

 
public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByPseudo(String pseudo);
    boolean existsByPseudo(String pseudo);
}
