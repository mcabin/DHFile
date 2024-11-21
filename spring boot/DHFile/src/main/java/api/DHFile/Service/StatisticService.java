package api.DHFile.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.DHFile.Entities.Statistic;
import api.DHFile.Repository.StatisticRepository;
import api.DHFile.enums.StatisticEnum;

@Service
public class StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;
    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }
    
    public Statistic updateStatisticMap(int id,Map<StatisticEnum,Integer> newMap){
       Statistic statToUpdate= this.statisticRepository.findById(id).orElse(null);
       if(statToUpdate!=null){
        statToUpdate.setStatisticMap(newMap);
        this.statisticRepository.save(statToUpdate);
       }
       return statToUpdate;
    }

    public Statistic updateStatisticMinMax(int id,int minLevel,int maxLevel){
        Statistic statToUpdate= this.statisticRepository.findById(id).orElse(null);
        if(statToUpdate!=null){
            statToUpdate.setMaxlevel(maxLevel);
            statToUpdate.setMinlevel(minLevel);
            this.statisticRepository.save(statToUpdate);
       }
       return statToUpdate;
    }

}
