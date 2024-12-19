package api.DHFile.Controller.Response;

import api.DHFile.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse {
    private String username;
    private int id;

    public static UserInfoResponse create(User user){
        return UserInfoResponse.builder().id(user.getId()).username(user.getUsername()).build();
    }
}
