import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { url } from 'inspector';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class ApiUserService {
  private apiUrl='http://localhost:8080/api/user'
  constructor(private http:HttpClient) { }

  postData(user:User){
    return this.http.post(`${this.apiUrl}/create`,user);
  }
}
