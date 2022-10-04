import { Injectable } from '@angular/core'
import { HttpClient, HttpParams } from '@angular/common/http'
import { ApiConstants } from "../config/api.constants"
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class SystemService {

  constructor(private http: HttpClient) {
    
  }

  getDateSystem(selectedTz: string) {
    let queryParams = new HttpParams()
    queryParams = queryParams.append("timezone", selectedTz)
    return this.http.get(environment.rooturl + ApiConstants.URI_DATE_SYSTEM, { params:queryParams })
  }
  
}
