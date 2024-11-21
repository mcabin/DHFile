package api.DHFile.Controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.DHFile.Entities.User;
import api.DHFile.Service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController()
@RequestMapping(path="user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path="create", consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody User user){
        this.userService.create(user);
    }


    @PostMapping( path="check",consumes = APPLICATION_JSON_VALUE)
    public boolean validatePassword(@RequestParam User user) {
        return this.userService.passwordCheck(user);
    }
    

}
