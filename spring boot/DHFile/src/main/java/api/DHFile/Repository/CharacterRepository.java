package api.DHFile.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import api.DHFile.Entities.Character;
public interface CharacterRepository extends JpaRepository<Character,Integer> {
    boolean existsByFirstnameAndLastname(String firstname,String lastname );
    Optional<Character> findByFirstnameAndLastname(String firstname,String lastname);
    List<Character> findByLastname(String lastname);
}
