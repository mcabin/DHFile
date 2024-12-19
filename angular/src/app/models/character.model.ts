import { Skill } from "./skill.model";
import { Statistic, StatisticResponse } from "./statistic.model";
import {StatisticEnum} from "./enum/statistic.enum"

export interface CharacterResponse{
    firstname: string;
    lastname: string;
    age: number;
    ppImgLink: string;
    nationality: string;
    username: string;
    statisic:StatisticResponse;
}
export interface CharacterRequest {
    firstname: string;
    lastname: string;
    age: number;
    ppImgLink: string;
    nationality: string;
    username: string;
    statMap: Map<StatisticEnum, number>;
    minStatValue: number;
    maxStatValue: number;
}

export class Character{
    skills:Skill[]=[];
    constructor(public firstname:string,public lastname:string,public nationality:string,public age:number,public stat:Statistic,public ppImgLink:string){
    }

    

    addSkill(newSkill:Skill){
        this.skills.push(newSkill);
    }
}