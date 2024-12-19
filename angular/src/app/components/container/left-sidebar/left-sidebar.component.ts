import { Component } from '@angular/core';
import { ContainerVariableService } from '../../../service/container/container-variable.service';
@Component({
  selector: 'app-left-sidebar',
  imports: [],
  templateUrl: './left-sidebar.component.html',
  styleUrl: './left-sidebar.component.css',
  standalone:true
})
export class LeftSidebarComponent {
  constructor(public containerVariable: ContainerVariableService) {}

  
}
