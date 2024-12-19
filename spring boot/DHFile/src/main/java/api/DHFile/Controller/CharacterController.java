package api.DHFile.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.DHFile.Service.AuthenticationService;
import api.DHFile.Service.CharacterService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import api.DHFile.Controller.Request.CharacterRequest;
import api.DHFile.Controller.Request.UserInfoRequest;
import api.DHFile.Controller.Response.CharacterResponse;
import api.DHFile.Entities.Character;
import api.DHFile.Entities.Statistic;
import api.DHFile.Entities.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping(path="character")
public class CharacterController {
    private CharacterService characterService;
    private AuthenticationService authService;
    public CharacterController(CharacterService characterService, AuthenticationService authService) {
        this.characterService = characterService;
        this.authService=authService;
    }
    
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterResponse> create(@RequestBody CharacterRequest charaRequest){
        User user=this.authService.findById(charaRequest.getUser().getId());
        if(user==null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        Character character=Character.builder()
        .age(charaRequest.getAge())
        .firstname(charaRequest.getFirstname())
        .lastname(charaRequest.getLastname())
        .ppImgLink(charaRequest.getPpImgLink())
        .statistic( new Statistic(charaRequest.getMaxStatValue(),charaRequest.getMinStatValue(),charaRequest.getStatMap()) )
        .user(user)
        .build();
        this.characterService.create(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(CharacterResponse.createResponse(character));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<CharacterResponse> getAll() {
        return CharacterResponse.creatResponses(this.characterService.findAll());
    }

    @ResponseStatus(value=HttpStatus.OK)
    @GetMapping(path= "{id}" ,produces = APPLICATION_JSON_VALUE)
    public CharacterResponse getById(@PathVariable int id){
        return CharacterResponse.createResponse(this.characterService.findById(id));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "name/{firstname}/{lastname}")
    public CharacterResponse getByName(@PathVariable String firstname,@PathVariable String lastname) {
        return CharacterResponse.createResponse(this.characterService.findByFullname(firstname, lastname));
    }
    
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(path="{id}")
    public void deleteById(@PathVariable int id){
        this.characterService.deleteById(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path="/byUser")
    public List<CharacterResponse> getMethodName(@RequestBody UserInfoRequest userInfo) {
        System.out.println(userInfo);
        return CharacterResponse.creatResponses(this.characterService.findByUser(userInfo.getUsername()));
    }
    
}
