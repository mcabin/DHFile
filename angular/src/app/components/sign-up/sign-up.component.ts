import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../service/api/auth-service.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
    selector: 'app-sign-up',
    imports: [RouterLink,CommonModule,FormsModule],
    templateUrl: './sign-up.component.html',
    styleUrl: './sign-up.component.css',
    standalone:true
})
export class SignUpComponent {
    username:string='';
    password:string='';
    confirmPassword:string='';
    constructor(private authService:AuthService,private  router:Router){}
  register(){
    if(this.password==this.confirmPassword && this.password!=''){
        this.authService.register({ pseudo: this.username, password: this.password }).subscribe({
            next: (response) => {
              this.authService.saveToken(response.token);
              console.log('Connexion réussie!');
              this.router.navigateByUrl("/login");
            },
            error: (err) => {
              console.error(err);
            }
          });
    }
    
  }
}
