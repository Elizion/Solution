import { Injectable } from '@angular/core'
import { HttpClient, HttpParams } from '@angular/common/http'
import { ApiConstants } from "../config/api.constants"
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private http: HttpClient) {
    
  }
  
  createTicket(storePriceRequest : any) {  
    return this.http.post(environment.rooturl + ApiConstants.URI_TICKET_CREATED, storePriceRequest, { observe: 'response' })  
  }

  getTickets() {  
    return this.http.get(environment.rooturl + ApiConstants.URI_GET_TICKET_ACTIVES, { observe: 'response', withCredentials: true })
  }

  calculatedTicket(ticket : any) {
        
    const calculatedTicketRequest = { 
      "idTicket": ticket.id, 
      "idStore": ticket.idStore, 
      "idMaterial": ticket.idMaterial,
      "date": ticket.date
    }
    
    return this.http.post(environment.rooturl + ApiConstants.URI_CALCULATED_TICKET, calculatedTicketRequest, { observe: 'response' })  
  }

  reportCalculatedTicket() {  
    return this.http.post(environment.rooturl + ApiConstants.URI_REPORT_TICKETS, { observe: 'response', withCredentials: true })
  }

  uploadFileTickets(event: File) {  
    const form = new FormData
    form.append('file', event)
    return this.http.post(environment.rooturl + ApiConstants.URI_UPLOAD_FILE_TICKET, form, { observe: 'response', withCredentials: true })
  }
  
  calculateMassive() {  
    return this.http.post(environment.rooturl + ApiConstants.URI_GENERATE_PRICE_MASSIVE, { observe: 'response', withCredentials: true })
  }
    
  validateTicket(ticket : any, codeStatus: any) {           
    const ticketRequest = { 
      "idTicket": ticket.id, 
      "idStore": ticket.idStore, 
      "idMaterial": ticket.idMaterial,
      "date": ticket.date,
      "codeStatus": codeStatus
    }  
    return this.http.put<any>(environment.rooturl + ApiConstants.URI_VALIDATE_TICKET, ticketRequest, { observe: 'response' }) 
  }

  deletedTicket(ticket : any) {
    let queryParams = new HttpParams()
    queryParams = queryParams.append("idTicket", ticket.id)
    return this.http.delete(environment.rooturl + ApiConstants.URI_DELETED_TICKET, { params:queryParams })  

  }
  
}
