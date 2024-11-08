import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MainSheetComponent } from "./components/main-sheet/main-sheet.component";
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MainSheetComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'DH-File';
}
