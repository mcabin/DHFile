import { Component, ViewEncapsulation } from '@angular/core';
import { PersonalInformationComponent } from "../personal-information/personal-information.component";
import { StatisticComponent } from "../statistic/statistic.component";

@Component({
  selector: 'app-main-sheet',
  standalone: true,
  imports: [PersonalInformationComponent, StatisticComponent],
  templateUrl: './main-sheet.component.html',
  styleUrl: './main-sheet.component.css',
  encapsulation:ViewEncapsulation.Emulated
})
export class MainSheetComponent {

}
