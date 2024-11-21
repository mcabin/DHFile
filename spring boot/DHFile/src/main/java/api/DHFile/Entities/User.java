package api.DHFile.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import api.DHFile.enums.RoleEnum;
@Entity(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String pseudo;
    private String password;
    private RoleEnum[] roles;

    
    public User() {
    }

    

    public String[] getRolesInString(){
       return Arrays.stream(this.roles).map(RoleEnum::getLabel).toArray(String[]::new);
    }
    public RoleEnum[] getRoles() {
        return roles;
    }
    public void setRoles(RoleEnum[] roles) {
        this.roles = roles;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
