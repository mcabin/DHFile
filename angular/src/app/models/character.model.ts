import { Skill } from "./skill.model";
import { Statistic } from "./statistic.model";
import {StatisticEnum} from "./enum/statistic.enum"

export class Character{
    skills:Skill[]=[];
    constructor(public firstname:string,public lastname:string,public nationality:string,public age:number,public stat:Statistic){
    }

    

    addSkill(newSkill:Skill){
        this.skills.push(newSkill);
    }
}