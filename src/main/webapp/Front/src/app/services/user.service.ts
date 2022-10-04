import { Injectable } from '@angular/core'
import { HttpClient, HttpParams } from '@angular/common/http'
import { UserModel } from '../model/user.model'
import { ApiConstants } from '../config/api.constants'
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
    
  }

  desactivatedUserByEmail(email: string) {    
    let queryParams = new HttpParams()
    queryParams = queryParams.append("email",email)
    return this.http.get(environment.rooturl + ApiConstants.URI_USER_DESACTIVATED, { params:queryParams })
  }

  activatedUserByEmail(email: string) {    
    let queryParams = new HttpParams()
    queryParams = queryParams.append("email",email)
    return this.http.get(environment.rooturl + ApiConstants.URI_USER_ACTIVED, { params:queryParams })
  }

  getUserActives() {
    return this.http.get(environment.rooturl + ApiConstants.URI_USER_ACTIVES, { observe: 'response', withCredentials: true })
  }
  
  userCreated(userModel : UserModel) {  
    return this.http.post(environment.rooturl + ApiConstants.URI_USER_CREATED, userModel, { observe: 'response' })  
  }

}
