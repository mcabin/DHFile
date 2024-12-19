import { Component, Input, Type } from '@angular/core';
import { CommonModule, NgComponentOutlet } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { ContainerVariableService } from '../../../service/container/container-variable.service';
import { HeaderComponent } from "../header/header.component";
@Component({
  selector: 'app-default-page-container',
  imports: [NgComponentOutlet, CommonModule, HeaderComponent,HeaderComponent],
  templateUrl: './default-page-container.component.html',
  styleUrl: './default-page-container.component.css',
  standalone:true
})
export class DefaultPageContainerComponent {
  @Input() dynamicContent!: Type<any>;
  constructor(private route:ActivatedRoute,private router: Router,public containerVariable: ContainerVariableService){}
  
 

  ngOnInit() {
    this.dynamicContent = this.route.snapshot.data['dynamicContent'];
  }
}
