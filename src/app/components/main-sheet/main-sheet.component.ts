import { Component, ViewEncapsulation } from '@angular/core';
import { PersonalInformationComponent } from "../personal-information/personal-information.component";
import { StatisticComponent } from "../statistic/statistic.component";
import { Character } from '../../models/character.model';
import { Statistic } from '../../models/statistic.model';

@Component({
  selector: 'app-main-sheet',
  standalone: true,
  imports: [PersonalInformationComponent, StatisticComponent],
  templateUrl: './main-sheet.component.html',
  styleUrl: './main-sheet.component.css',
  encapsulation:ViewEncapsulation.Emulated
})
export class MainSheetComponent {
  character:Character=new Character("Jhon","Red","English",44,new Statistic(0,10));
  
}
