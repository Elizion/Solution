import { Injectable } from '@angular/core'
import { HttpClient, HttpParams } from '@angular/common/http'
import { ApiConstants } from "../config/api.constants"
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  constructor(private http: HttpClient) {
    
  }

  getListStore() {
    return this.http.get(environment.rooturl + ApiConstants.URI_STORE_ACTIVES , { observe: 'response', withCredentials: true })
  }

  getStoreTypes() {
    return this.http.get(environment.rooturl + ApiConstants.URI_GET_STORE_TYPES , { observe: 'response', withCredentials: true })
  }

  getStorePrices(idStore: any) {
    let queryParams = new HttpParams()
    queryParams = queryParams.append("idStore", idStore)
    return this.http.get(environment.rooturl + ApiConstants.URI_GET_STORE_PRICES , { params:queryParams })
  }
  
}
