import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { User } from '../../models/user.model';
import { ApiUserService } from '../../service/api-user.service';
import { response } from 'express';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {

  constructor(private apiService:ApiUserService){}

    signUp(pseudo:string,password:string,passwordConfirmation:string){
      if(password!=passwordConfirmation){
        //Handle not same password
        console.log("Pas identique");
      }
      else{
        let user:User=new User(pseudo,password)
        this.apiService.postData(user).subscribe({
          next: (response)=>{
            console.log("Réponse de l'API",response);
          },
          error:(error)=>{
            console.error('Erreur lors de l\'envoi des données:', error);
          }
        })
      }

    }
}
