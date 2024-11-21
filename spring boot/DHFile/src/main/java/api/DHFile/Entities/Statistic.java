package api.DHFile.Entities;
import java.util.HashMap;
import java.util.Map;

import api.DHFile.enums.StatisticEnum;
import jakarta.persistence.*;
@Entity(name="STATISTIC")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "MAX_LEVEL")
    private int maxLevel;
    @Column(name = "MIN_LEVEL")
    private int minLevel;
    
    
    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name="MAP_KEY")
    @Column(name = "MAP_VALUE")
    @CollectionTable(name="STATISTIC_MAP", joinColumns=@JoinColumn(name="STATISTIC_ID"))
    private Map<StatisticEnum,Integer> statisticMap;

    public Statistic(){
        initializeMap();
    }
    public Statistic( int maxLevel, int minLevel, Map<StatisticEnum, Integer> statisticMap) {
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
        this.statisticMap = statisticMap;
        this.initializeMap();
    }
    private void initializeMap(){
        this.statisticMap=new HashMap<StatisticEnum,Integer>();
        for(StatisticEnum statEnum: StatisticEnum.values()){
            this.statisticMap.put(statEnum, 1);
        }
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMaxlevel() {
        return maxLevel;
    }
    public void setMaxlevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
    public int getMinlevel() {
        return minLevel;
    }
    public void setMinlevel(int minLevel) {
        this.minLevel = minLevel;
    }
    public Map<StatisticEnum, Integer> getStatisticMap() {
        return statisticMap;
    }
    public void setStatisticMap(Map<StatisticEnum, Integer> myMap) {
        this.statisticMap = myMap;
    }
    
}
