import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { ApiConstants } from "../config/api.constants"
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class PriceService {

  constructor(private http: HttpClient) {
    
  }

  modifiedStorePrice(priceRequest : any) {   
    
    const storePriceRequest = { 
      "idPrice": priceRequest.idPrice, 
      "price": priceRequest.price,
      "idStore": priceRequest.idStore,
      "idMaterial": priceRequest.idMaterial,
      "idUnit": priceRequest.idUnit,
      "date": new Date ()
    }

    return this.http.put<any>(environment.rooturl + ApiConstants.URI_MODIFIED_PRICE, storePriceRequest, { observe: 'response' }) 

  }

}
