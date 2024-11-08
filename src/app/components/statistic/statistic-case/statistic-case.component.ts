import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-statistic-case',
  standalone: true,
  imports: [],
  templateUrl: './statistic-case.component.html',
  styleUrl: './statistic-case.component.css'
})
export class StatisticCaseComponent {
  @Input() imgPath!:string;
  @Input() type!:string;
}
