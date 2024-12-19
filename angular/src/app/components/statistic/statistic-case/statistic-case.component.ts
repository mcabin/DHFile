import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Character } from '../../../models/character.model';
import { StatisticEnum } from '../../../models/enum/statistic.enum';
import { Statistic } from '../../../models/statistic.model';
@Component({
    selector: 'app-statistic-case',
    imports: [FormsModule],
    templateUrl: './statistic-case.component.html',
    styleUrl: './statistic-case.component.css',
    standalone:true
})
export class StatisticCaseComponent {
  @Input({required:true}) imgPath!:string;
  @Input({required:true}) character!:Character;
  @Input({required:true}) type!:StatisticEnum;

  get maxLevel():number {
    const max=this.character?.stat.maxLevel;
    if(max!=undefined)
      return max;
    else return Number.MAX_SAFE_INTEGER;
  }
  get minLevel():number {
    const min=this.character.stat.minLevel;
    if(min!=undefined)
      return min;
    else return 0;

  }
  allowOnlyNumbers(event: KeyboardEvent) {
    const charCode = event.key;
    if (!/[0-9]/.test(charCode)) {
      event.preventDefault();
    }
  }

  ngOnInit() {
    const stat = this.character?.stat;
    if (stat) {
      this.tmpLevel = stat.statMap.get(this.type);
    }
  }

  get tmpLevel(): number | undefined {
    return this.character?.stat.statMap.get(this.type);
  }

  set tmpLevel(value: number | undefined) {
    const stat = this.character?.stat;
    if (stat ) {
      if(value !== undefined)
        if(value>stat.maxLevel)
          stat.statMap.set(this.type,stat.maxLevel)
        else if(value<stat.minLevel)
          stat.statMap.set(this.type,stat.minLevel)
        else
          stat.statMap.set(this.type,value)
      else
        stat.statMap.set(this.type,0);
    }
  }
  incrementValue(){
    var stat = this.character?.stat;
    if(stat){
      var level=stat.statMap.get(this.type)
      if(level!=undefined)
        stat.statMap.set(this.type,level+1)
    }
    
  }
  decrementValue(){
    var stat = this.character?.stat;
    if(stat){
      var level=stat.statMap.get(this.type)
      if(level!=undefined)
        stat.statMap.set(this.type,level-1)
    }
  }
}
