import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { ApiConstants } from "../config/api.constants"
@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http: HttpClient) {
    
  }

  getApiFake() {
    return this.http.get(ApiConstants.URI_FAKE_USERS, { observe: 'response', withCredentials: true })
  }
  
}
