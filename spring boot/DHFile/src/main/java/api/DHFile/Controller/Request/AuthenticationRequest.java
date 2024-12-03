package api.DHFile.Controller.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String pseudo;
    private String password;
    
    @Override
    public String toString(){
        return pseudo+" "+password;
    }
}
