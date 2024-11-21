package api.DHFile.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import api.DHFile.Entities.User;
import api.DHFile.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordService;

    public UserService(UserRepository userRepository,PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService=passwordService;
    }

    public User searchById(int id){
       return this.userRepository.findById(id).orElse(null);
    }

    public User searchByPseudo(String pseudo){
        return this.userRepository.findByPseudo(pseudo).orElse(null);
    }

    public void create(User user){
        if(!this.userRepository.existsByPseudo(user.getPseudo())){
            String encodedPassword=this.passwordService.hashPassword(user.getPassword());
            user.setPassword(encodedPassword);
            this.userRepository.save(user);
        }
    }

    public boolean passwordCheck(User user){
        Optional<User> optional=this.userRepository.findByPseudo(user.getPseudo());
        if(optional.isPresent()){
            User databaseUser=optional.get();
            return this.passwordService.matches(user.getPassword(), databaseUser.getPassword());
        }
        else
            return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByPseudo(username)
            .orElseThrow(()->new UsernameNotFoundException("User not found"));
        
            return org.springframework.security.core.userdetails.User.builder().username(user.getPseudo()).
            password(user.getPassword()).roles(user.getRolesInString()).build();

    }

   
    
    
}
