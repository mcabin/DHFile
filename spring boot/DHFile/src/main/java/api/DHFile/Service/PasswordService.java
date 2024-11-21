package api.DHFile.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public String hashPassword(String plainPassword){
        return passwordEncoder.encode(plainPassword);
    }

    public boolean matches(String plainPassword,String encodedPassword){
        return passwordEncoder.matches(plainPassword, encodedPassword);
    }
}
