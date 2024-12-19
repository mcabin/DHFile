package api.DHFile.Controller.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

import api.DHFile.Entities.Statistic;
import api.DHFile.enums.StatisticEnum;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticResponse {
    private Map<StatisticEnum, Integer> statMap;
    private int minStatValue;
    private int maxStatValue;

    public static StatisticResponse create(Statistic statistic){
        return StatisticResponse.builder().maxStatValue(statistic.getMaxlevel())
        .minStatValue(statistic.getMinlevel())
        .statMap(statistic.getStatisticMap()).build();
    }
}
