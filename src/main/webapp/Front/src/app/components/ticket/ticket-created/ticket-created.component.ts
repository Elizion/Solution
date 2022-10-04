import { Component, OnInit } from '@angular/core'
import { TicketService } from 'src/app/services/ticket.service'
import { AlertService } from 'src/app/services/alert.service'
import { AlertConstants } from 'src/app/config/alert.constants'
import * as moment from 'moment-timezone'
import { CONFIG } from '../../../config/config.constants'
import { StoreService } from 'src/app/services/store.service'
import { MaterialService } from 'src/app/services/material.service'

@Component({
  selector: 'app-ticket-created',
  templateUrl: './ticket-created.component.html',
  styleUrls: ['./ticket-created.component.css']
})
export class TicketCreatedComponent implements OnInit {


  ticket: any

  folio: any
  badge: any
  badgeSmurfit: any
  idStore: any
  idMaterial: any
  carrier: any
  weight: any
  weigthOk: any
  puch: any
  operator: any
  date: any
  observations: any

  selectedIdStore: any
  selectedIdMaterial: any
  
  stores: any
  materials: any

  constructor(private storeService: StoreService, private ticketService: TicketService, private alertService: AlertService, private materialService: MaterialService) { 

  }

  ngOnInit(): void {
  
    this.storeService.getListStore().subscribe(      
      responseData => {     
        this.stores = responseData.body['data']
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )
    
    this.getMaterials()

  }

  materialChanged(idMaterial: number): void {
    this.selectedIdMaterial = idMaterial
  }

  storeChanged(idStore: number): void {
    this.selectedIdStore = idStore
  }
  
  getMaterials(): void {
    this.materialService.getMaterials().subscribe(                  
      responseData => {                     
        this.materials = responseData.body['data']     
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )
  }

  createTicket(): void {
    
    const dt = new Date( this.date )

    const ticketRequest = { 
      "folio": this.folio, 
      "badge": this.badge, 
      "badgeSmurfit": this.badge, 
      "idStore": this.selectedIdStore, 
      "idMaterial": this.selectedIdMaterial, 
      "carrier": this.carrier, 
      "weight": this.weight, 
      "weigthOk": this.weigthOk,
      "puch": this.puch, 
      "operator": this.operator,
      "date": dt,
      "observations": this.observations 
    }

    this.ticketService.createTicket(ticketRequest).subscribe(      
      
      responseData => {     
        
        this.ticket = responseData.body['data']
        this.alertService.showNotification(this.ticket, "Success", AlertConstants.SUCCESS)

      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }

    )

  }

  uploadFileTickets(event: File) {    
    this.ticketService.uploadFileTickets(event).subscribe(            
      responseData => {             
        let reponse = responseData.body['data']
        this.alertService.showNotification(reponse, "Success", AlertConstants.SUCCESS)
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )
  }
  
}
