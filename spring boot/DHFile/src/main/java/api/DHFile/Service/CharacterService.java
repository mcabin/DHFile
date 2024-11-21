package api.DHFile.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.DHFile.Entities.Character;
import api.DHFile.Repository.CharacterRepository;
@Service
public class CharacterService {
    @Autowired
    CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    
    public Character findById(int id){
        return characterRepository.findById(id).orElse(null);
    }

    public List<Character> findAll(){
        return this.characterRepository.findAll();
    }

    public void create(Character newCharacter){
        if(!this.characterRepository.existsByFirstnameAndLastname(newCharacter.getFirstname(), newCharacter.getLastname()))
            this.characterRepository.save(newCharacter);
    }

    public Character findByFullname(String firstname,String lastName){
        return this.characterRepository.findByFirstnameAndLastname(firstname, lastName).orElse(null);
    }

    public List<Character> findByLastName(String lastname){
        return this.characterRepository.findByLastname(lastname);
    }

    public void deleteById(int id){
        this.characterRepository.deleteById(id);
    }
}
