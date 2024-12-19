package api.DHFile.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import api.DHFile.Entities.Character;
import api.DHFile.Entities.User;
public interface CharacterRepository extends JpaRepository<Character,Integer> {
    boolean existsByFirstnameAndLastname(String firstname,String lastname );
    Optional<Character> findByFirstnameAndLastname(String firstname,String lastname);
    List<Character> findByLastname(String lastname);
    List<Character> findByUser(User user);    
}
