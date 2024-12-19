import { Injectable } from '@angular/core';
import { Character,CharacterRequest } from '../../models/character.model';
import { AuthService } from './auth-service.service';
import { HttpClient } from '@angular/common/http';
import { StatisticEnum } from '../../models/enum/statistic.enum';
import { last } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class CharacterApiService {
  private apiUrl = 'http://localhost:8080/api/character'; // URL de l'API backend
  constructor(private authService: AuthService, private http: HttpClient) { }

  createNewCharacter(character: Character):boolean {
    let username = this.authService.getName();
    if (username) {
      let body:CharacterRequest = {
        firstname: character.firstname,
        lastname: character.lastname,
        age: character.age,
        ppImgLink: character.ppImgLink,
        nationality: character.nationality,
        username: username,
        statMap: character.stat.statMap,
        maxStatValue: character.stat.maxLevel,
        minStatValue: character.stat.minLevel
      }
      this.http.post<{  }>(`${this.apiUrl}`,body).subscribe({
        next: (response: any) => {
          console.log(response);
          return true;
        },
        error: (err:any) => {
          console.error(err);
          return false;
        }
      })
    }
    return false;
  }
}
