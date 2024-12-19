import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { AuthService } from '../../service/api/auth-service.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
@Component({
    selector: 'app-log-page',
    imports: [RouterLink,FormsModule,CommonModule],
    templateUrl: './log-page.component.html',
    styleUrl: './log-page.component.css',
    standalone:true
})
export class LogPageComponent {
    username:string = '';
    password:string = '';
    errorMessage:boolean=false;
    constructor(private authService: AuthService,private router:Router) {}


    
    login() {
        var isSuccess:boolean=this.authService.login({ pseudo: this.username, password: this.password });
        if(isSuccess){
          this.errorMessage=false;
        }
        else{
          this.errorMessage=true;

        }
      }
}
