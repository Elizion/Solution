import { Component, OnInit } from '@angular/core'
import { TicketService } from 'src/app/services/ticket.service'
import { MaterialService } from 'src/app/services/material.service'

@Component({
  selector: 'app-ticket-historical',
  templateUrl: './ticket-historical.component.html',
  styleUrls: ['./ticket-historical.component.css']
})
export class TicketHistoricalComponent implements OnInit {

  tickets: any
  ticket: any

  responseCalculated: any
  base64String: string
  
  selectedItem = null;

  constructor(private ticketService: TicketService, private materialService: MaterialService) { }

  ngOnInit(): void {


    this.ticketService.getTickets().subscribe(                  
      responseData => {                     
        this.tickets = responseData.body['data']     
      }, error => {
        alert(error.error.message)
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
        alert(response)

      }, error => {

        alert(error.error.message)

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
        alert("Ticket invalidado correctamente.")

      }, error => {

        alert(error.error.message)

      }

    )

  }

  modifiedTicket(ticket: any, i: any): void {

    debugger

    this.ticket = ticket    
    this.selectedItem = ticket
    /*
    this.ticketService.modifiedTicket(ticket).subscribe(                  
      
      responseData => {                     

        this.responseCalculated = responseData.body['data']
        
        this.ticketService.getTickets().subscribe(                  
          responseData => {                     
            this.tickets = responseData.body['data']     
          }, error => {
            alert(error.error.message)
          }
        )

      }, error => {
        alert(error.error.message)
      }

    )
  */
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
            alert(error.error.message)
          }
        )

      }, error => {
        alert(error.error.message)
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
        alert(error.error.message)
      }
    )
  }

  calculateMassive( ) {          
    this.ticketService.calculateMassive().subscribe(              
      responseData => {               
        let reponse = responseData['data']
        alert(reponse)  
        this.ticketService.getTickets().subscribe(                  
          responseData => {                     
            this.tickets = responseData.body['data']     
          }, error => {
            alert(error.error.message)
          }
        )
      }, error => {
        alert(error.error.message)
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
        alert(response)

      }, error => {

        alert(error.error.message)

      }

    )

  }

}
