import { Component, OnInit } from '@angular/core'
import { TicketService } from 'src/app/services/ticket.service'
import { AlertService } from 'src/app/services/alert.service'
import { AlertConstants } from 'src/app/config/alert.constants'
import { MaterialService } from 'src/app/services/material.service'

@Component({
  selector: 'app-ticket-calculated',
  templateUrl: './ticket-calculated.component.html',
  styleUrls: ['./ticket-calculated.component.css']
})
export class TicketCalculatedComponent implements OnInit {

  tickets: any
  ticket: any
  responseCalculated: any
  base64String: string

  constructor(private ticketService: TicketService, private alertService: AlertService, private materialService: MaterialService) { }

  ngOnInit(): void {
    
    this.ticketService.getTickets().subscribe(                  
      responseData => {                     
        this.tickets = responseData.body['data']     
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )
    
  }
  
  validateTicket(ticket: any, i: any): void {

    let codeStatus = 'SYS001'

    this.ticket = ticket    
    
    this.ticketService.validateTicket(ticket, codeStatus).subscribe(                  
      
      responseData => {                     

        document.getElementsByClassName("code-status-"+i)[0].textContent = 'Si'
        
        let response = responseData.body['data']
        this.alertService.showNotification(response, "Success", AlertConstants.SUCCESS)

      }, error => {

        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)

      }

    )

  }

  revertTicket(ticket: any, i: any): void {
    
    let codeStatus = 'SYS000'

    this.ticket = ticket    
    
    this.ticketService.validateTicket(ticket, codeStatus).subscribe(                  
      
      responseData => {                     
        
        document.getElementsByClassName("code-status-"+i)[0].textContent = 'No'

        let response = responseData.body['data']
        this.alertService.showNotification(response, "Success", AlertConstants.SUCCESS)

      }, error => {

        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)

      }

    )

  }

  calculatedTicket(ticket: any): void {

    this.ticket = ticket    
    
    this.ticketService.calculatedTicket(ticket).subscribe(                  
      
      responseData => {                     

        this.responseCalculated = responseData.body['data']
        
        this.ticketService.getTickets().subscribe(                  
          responseData => {                     
            this.tickets = responseData.body['data']     
          }, error => {
            this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
          }
        )

      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }

    )

  }
    
  reportCalculatedTicket(): void {
    this.ticketService.reportCalculatedTicket().subscribe(                        
      responseData => {                     
        this.base64String = responseData['data']
        let file = new Blob([this.base64String], { type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" });
        let fileUrl = URL.createObjectURL(file);
        let hiddenElement = document.createElement('a');                    
        //hiddenElement.download = myJson.name + '_' + myJson.dateReport + '_' + item.descShort + myJson.reportClientCatalog.idCatalog + extension;
        hiddenElement.download = "hola.xlsx";
        hiddenElement.style.display = "none";
        hiddenElement.target = '_blank';
        hiddenElement.href = fileUrl;
        document.body.appendChild(hiddenElement);
        hiddenElement.click();        
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )
  }

  calculateMassive( ) {          
    this.ticketService.calculateMassive().subscribe(              
      responseData => {               
        let reponse = responseData['data']
        this.alertService.showNotification(reponse, "Success", AlertConstants.SUCCESS)  
        this.ticketService.getTickets().subscribe(                  
          responseData => {                     
            this.tickets = responseData.body['data']     
          }, error => {
            this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
          }
        )
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }  
    )
  }

  deletedTicket(ticket: any, i: any): void {

    this.ticket = ticket    
    
    const elements = document.getElementsByClassName("row-ticket-"+i);
    
    while(elements.length > 0){
        elements[0].parentNode.removeChild(elements[0]);
    }

    this.ticketService.deletedTicket(ticket).subscribe(                  
      
      responseData => {                     
    
        let response = responseData['data']
        this.alertService.showNotification(response, "Success", AlertConstants.SUCCESS)

      }, error => {

        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)

      }

    )

  }

}
