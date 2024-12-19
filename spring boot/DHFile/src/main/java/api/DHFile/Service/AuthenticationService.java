package api.DHFile.Service;

import api.DHFile.Entities.User;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api.DHFile.Controller.Request.AuthenticationRequest;
import api.DHFile.Controller.Request.RegisterRequest;
import api.DHFile.Controller.Response.AuthenticationResponse;
import api.DHFile.Repository.UserRepository;
import api.DHFile.enums.RoleEnum;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPseudo(), request.getPassword()));
        
        var user=repository.findByPseudo(request.getPseudo()).orElseThrow(()->new UsernameNotFoundException("User not found !"));
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).id(user.getId()).build();
    }

    public User findByUsername(String username){
        return this.repository.findByPseudo(username).orElse(null);
    }

    public User findById(int id){
        return this.repository.findById(id).orElse(null);
    }

    public AuthenticationResponse register(RegisterRequest request) throws Exception {
        var user=User.builder()
        .password(passwordEncoder.encode(request.getPassword()))
        .pseudo(request.getPseudo()).
        role(RoleEnum.USER).build();
        if(repository.existsByPseudo(user.getPseudo())){
            throw new Exception("Ce pseudo est déja utilisé");
        }
        repository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).id(user.getId()).build();
    }

    public AuthenticationResponse refreshToken(String token) throws Exception{
        String username=jwtService.extractUsername(token);
        User user=repository.findByPseudo(username).orElse(null);
        if(user!=null){
            if(jwtService.isTokenValid(token, user))
            {
                var newToken=jwtService.generateToken(user);
                return AuthenticationResponse.builder().token(newToken).id(user.getId()).build();
            }
            else{
                throw new Exception("Le token est invalide.");
            }
        }
        else{
            throw new Exception("L'utilisateur n'existe pas.");
        }
    }
    
}
