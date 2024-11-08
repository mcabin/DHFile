import { Component ,ViewEncapsulation} from '@angular/core';
import { StatisticCaseComponent } from "./statistic-case/statistic-case.component";

@Component({
  selector: 'app-statistic',
  standalone: true,
  imports: [StatisticCaseComponent],
  templateUrl: './statistic.component.html',
  styleUrl: './statistic.component.css',
  encapsulation:ViewEncapsulation.Emulated
})
export class StatisticComponent {

}
