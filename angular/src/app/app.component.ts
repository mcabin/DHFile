import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule, RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  isSidebarClosed:boolean=false;
  title = 'DH-File';

  toggleSidebar() {
    this.isSidebarClosed=!this.isSidebarClosed;
    console.log(this.isSidebarClosed);
    
  }
}
