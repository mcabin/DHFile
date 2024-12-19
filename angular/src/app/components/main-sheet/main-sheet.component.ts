import { Component, ViewEncapsulation } from '@angular/core';
import { PersonalInformationComponent } from "../personal-information/personal-information.component";
import { StatisticComponent } from "../statistic/statistic.component";
import { Character } from '../../models/character.model';
import { Statistic } from '../../models/statistic.model';
import { CharacterApiService } from '../../service/api/character-api.service';

@Component({
    selector: 'app-main-sheet',
    imports: [PersonalInformationComponent, StatisticComponent],
    templateUrl: './main-sheet.component.html',
    styleUrl: './main-sheet.component.css',
    encapsulation: ViewEncapsulation.Emulated
})
export class MainSheetComponent {
  constructor(private characterApiService:CharacterApiService){}
  character:Character=new Character("Jhon","Red","English",44,new Statistic(0,10),"img/Aki.png");
  
  charaTest(){
    this.characterApiService.createNewCharacter(this.character);
  }
}
