import { Skill } from "./skill.model";
import { Statistic } from "./statistic.model";

export class Character{
    firstname:string="FirstName";
    lastname:string="LastName";
    nationality:string="France"
    age:number=20;
    skills:Statistic[]=[];
    statistic:Skill[]=[];
}