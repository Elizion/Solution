import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserModel } from "../model/user.model";
import { ApiConstants } from "../config/api.constants";
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {
    
  }

  startSignin(userModel: UserModel) {
    window.sessionStorage.setItem("userdetails",JSON.stringify(userModel));
    return this.http.get(environment.rooturl + ApiConstants.URI_AUTH, { observe: 'response', withCredentials: true });
  }

}
