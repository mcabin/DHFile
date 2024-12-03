import { Component ,Input,ViewEncapsulation} from '@angular/core';
import { StatisticCaseComponent } from "./statistic-case/statistic-case.component";
import { Character } from '../../models/character.model';
import { StatisticEnum } from '../../models/enum/statistic.enum';
@Component({
  selector: 'app-statistic',
  standalone: true,
  imports: [StatisticCaseComponent],
  templateUrl: './statistic.component.html',
  styleUrl: './statistic.component.css',
  encapsulation:ViewEncapsulation.Emulated
})

export class StatisticComponent {
  @Input({required:true}) character!:Character;
  StatisticEnum=StatisticEnum;
}