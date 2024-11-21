package api.DHFile.Controller;


import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.DHFile.Entities.Statistic;
import api.DHFile.Service.StatisticService;
import api.DHFile.enums.StatisticEnum;

@RestController
@RequestMapping(path="statistic")
public class StatisticController {
    private StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }
    

    @PutMapping(path="{id}/map")
    public Statistic changeStatisticMap(@PathVariable int id, @RequestBody Map<StatisticEnum,Integer> map ) {        
        return this.statisticService.updateStatisticMap(id, map);
    }

    @PutMapping(path = "{id}/limit/{min}/{max}")
    public Statistic changeStatisticLimit(@PathVariable int id,@PathVariable int min,@PathVariable int max ) {
        return this.statisticService.updateStatisticMinMax(id,min,max);
    }
    
}
