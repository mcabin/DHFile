import { Component } from '@angular/core';
import { MainSheetComponent } from "../main-sheet/main-sheet.component";

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [MainSheetComponent],
  templateUrl: './character.component.html',
  styleUrl: './character.component.css'
})
export class CharacterComponent {

}
