package api.DHFile.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.DHFile.Service.CharacterService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import api.DHFile.Entities.Character;

import org.springframework.http.HttpStatus;



@RestController
@RequestMapping(path="character")
public class CharacterController {
    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }
    
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Character character){
        this.characterService.create(character);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Character> getAll() {
        return this.characterService.findAll();
    }

    @ResponseStatus(value=HttpStatus.OK)
    @GetMapping(path= "{id}" ,produces = APPLICATION_JSON_VALUE)
    public Character getById(@PathVariable int id){
        return this.characterService.findById(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "name/{firstname}/{lastname}")
    public Character getByName(@PathVariable String firstname,@PathVariable String lastname) {
        return this.characterService.findByFullname(firstname, lastname);
    }
    
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(path="{id}")
    public void deleteById(@PathVariable int id){
        this.characterService.deleteById(id);
    }
}
