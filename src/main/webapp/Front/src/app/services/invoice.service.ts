import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { ApiConstants } from "../config/api.constants"
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  constructor(private http: HttpClient) {
    
  }

  getInvoicesByTikect() {  
    return this.http.get(environment.rooturl + ApiConstants.URI_GET_INVOICES_BY_TICKET, { observe: 'response', withCredentials: true })
  }

}
