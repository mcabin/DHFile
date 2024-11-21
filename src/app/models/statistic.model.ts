import { StatisticEnum } from "./enum/statistic.enum";

export class Statistic{

    public  statMap:Map<StatisticEnum,number>=new Map<StatisticEnum,number>;
    constructor(public minLevel:number,public maxLevel:number){
        this.statMapInitialize();
    }
    
    private statMapInitialize(){
        const keys=Object.values(StatisticEnum) as StatisticEnum[];
        keys.forEach((key)=>{
            this.statMap.set(key,1);
        })
    }
}