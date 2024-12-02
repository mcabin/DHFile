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
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user=User.builder()
        .password(passwordEncoder.encode(request.getPassword()))
        .pseudo(request.getPseudo()).
        role(RoleEnum.USER).build();

        repository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    
}
