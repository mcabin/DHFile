import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { JWT_TOKEN_KEY } from '../../app.constant';
import { jwtDecode } from 'jwt-decode';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/api/auth'; // URL de l'API backend
  refreshTokenTimeout!: NodeJS.Timeout;
  constructor(private http: HttpClient, private router: Router) { }

  login(credentials: { pseudo: string; password: string }):boolean {
    var isSuccess:boolean=true;
    this.http.post<{ token: string }>(`${this.apiUrl}/log`,
      credentials,
      { headers: { 'Content-Type': 'application/json' } }).subscribe({
        next: (response) => {
          this.saveToken(response.token);
          console.log('Connexion réussie!');
          this.router.navigateByUrl("");
          isSuccess=true;
          this.scheduleRefreshToken();
        },
        error: (err) => {
          console.error(err);
          isSuccess=false;
        }
      });
      return isSuccess;
  }

  register(credentials: { pseudo: string; password: string }) {
    return this.http.post<{ token: string }>(`${this.apiUrl}/register`,
      credentials,
      { headers: { 'Content-Type': 'application/json' } });
  }
  saveToken(token: string) {

    localStorage.setItem(JWT_TOKEN_KEY, token);
  }

  getToken(): string | null {

    return localStorage.getItem(JWT_TOKEN_KEY);
  }

  logout() {

    localStorage.removeItem(JWT_TOKEN_KEY);

    this.router.navigateByUrl("/login");


  }

  isLogged(): boolean {

    return this.getToken() != null;
  }

  private getTokenExpiration(): number {

    var token = this.getToken();
    if (token) {
      var decodedToken: any = jwtDecode(token);
      var expirationDate: number = decodedToken.exp;
      return expirationDate * 1000;
    }
    return 0;
  }

  private tokenIsValid() {

    var token = this.getToken();
    if (token) {
      return this.getTokenExpiration() > Date.now();
    }
    else {
      return false;
    }
  }
  checkToken(): Promise<void> {

    return new Promise((resolve, rejects) => {
      if (this.tokenIsValid()) {
        resolve();
      }
      else {
        this.logout();
        resolve();

      }

    })

  }

  getName(): string | null {

    let jwtToken = this.getName();
    if (jwtToken) {
      var jwt: any = jwtDecode(jwtToken);
      if (jwt.sub)
        return jwt.sub
    }
    return null;
  }

  getUserId():number|null{
    let jwtToken = this.getName();
    if (jwtToken) {
      var jwt:any=jwtDecode(jwtToken);
      if(jwt.id){
        return jwt.id;
      }
    }
    return null;
  }
  
  refreshToken() {
    this.http.post<{ token: string }>(`${this.apiUrl}/refreshToken`, this.getToken()).subscribe({
      next: (response) => {
        this.saveToken(response.token);
        this.scheduleRefreshToken();
        console.log("token has been refresh")
      },
      error: (err) => {
        this.logout();
        console.error(err);
      }
    })
  }
  private scheduleRefreshToken(): void {
    const token = this.getToken();
    if (!token) return;
    const timeout: number = this.getTokenExpiration() - Date.now() - (60 * 1000);

    if (timeout > 0) {
      this.refreshTokenTimeout = setTimeout(() => {
        this.refreshToken();
      }, timeout)
    }

  }
}
