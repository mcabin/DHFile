import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContainerVariableService {
  public leftSidebar:boolean=true;
  
  public toggleLeftSidebar(){
    this.leftSidebar=!this.leftSidebar;
  }
}
