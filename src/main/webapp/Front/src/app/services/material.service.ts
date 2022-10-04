import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { ApiConstants } from '../config/api.constants'
import { environment } from '../../environments/environment'

@Injectable()
export class MaterialService {

    constructor(private http: HttpClient) { }

    getMaterials() {
        return this.http.get(environment.rooturl + ApiConstants.URI_GET_MATERIALS, { observe: 'response', withCredentials: true })
    }

    getUnits() {
        return this.http.get(environment.rooturl + ApiConstants.URI_GET_UNITS, { observe: 'response', withCredentials: true })
    }

    createdStorePrice(storePriceRequest : any) {  
        return this.http.post(environment.rooturl + ApiConstants.URI_CREATED_PRICE, storePriceRequest, { observe: 'response' })  
    }

}