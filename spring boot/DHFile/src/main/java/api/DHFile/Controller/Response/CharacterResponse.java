package api.DHFile.Controller.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import api.DHFile.Entities.Character;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponse {

    private String firstname;
    private String lastname;
    private int age;
    private String ppImgLink;
    private String nationality;
    private UserInfoResponse user;
    private StatisticResponse statisic;

    public static CharacterResponse createResponse( Character character){
        CharacterResponse response=CharacterResponse.builder()
        .age(character.getAge())
        .firstname(character.getFirstname())
        .lastname(character.getLastname())
        .statisic(StatisticResponse.create(character.getStatistic()))
        .ppImgLink(character.getPpImgLink())
        .user(UserInfoResponse.create(character.getUser()))
        .build();
        return response;
    }

    public static List<CharacterResponse> creatResponses(List<Character> characters){
        List<CharacterResponse> characterResponses=new ArrayList<CharacterResponse>() ;
        for (Character character : characters) {
            characterResponses.add(createResponse(character));
        }
        return characterResponses;
    }
}
