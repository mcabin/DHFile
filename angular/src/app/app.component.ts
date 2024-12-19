import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
@Component({
    selector: 'app-root',
    imports: [RouterOutlet, FormsModule, RouterModule],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    standalone:true
})
export class AppComponent {
  title = 'DH-File';

 
}
