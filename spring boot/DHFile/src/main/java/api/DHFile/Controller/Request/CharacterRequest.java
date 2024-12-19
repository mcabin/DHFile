package api.DHFile.Controller.Request;

import java.util.Map;

import api.DHFile.enums.StatisticEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterRequest {
    private String firstname;
    private String lastname;
    private int age;
    private String ppImgLink;
    private String nationality;
    private UserInfoRequest user;
    private Map<StatisticEnum, Integer> statMap;
    private int minStatValue;
    private int maxStatValue;
}
