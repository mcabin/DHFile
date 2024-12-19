import { Component } from '@angular/core';
import { ContainerVariableService } from '../../../service/container/container-variable.service';
import { RouterLink,Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../../service/api/auth-service.service';

@Component({
  selector: 'app-header',
  imports: [RouterLink,CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
  standalone:true
})
export class HeaderComponent {
  constructor(public containerVariable:ContainerVariableService,private router:Router,private authService:AuthService){
  }
  
  changeRouter(routerPath:string){
    this.router.navigateByUrl(routerPath);
  }

  getName():string{
    var name=this.authService.getName();
    if(name)
      return name;
    return '';
  }
  
  logout(){
    this.authService.logout();
  }

  isLogged(){
    return this.authService.isLogged();
  }
}
