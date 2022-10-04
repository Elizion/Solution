import { Component, OnInit } from '@angular/core'
import { InvoiceService } from 'src/app/services/invoice.service'
import { AlertService } from 'src/app/services/alert.service'
import { AlertConstants } from 'src/app/config/alert.constants'

@Component({
  selector: 'app-ticket-comparative',
  templateUrl: './ticket-comparative.component.html',
  styleUrls: ['./ticket-comparative.component.css']
})
export class TicketComparativeComponent implements OnInit {

  ticketInvoices: any
  listInvoiceExcel: any

  constructor(private invoiceService: InvoiceService, private alertService: AlertService) { 



  }

  ngOnInit(): void {

    this.invoiceService.getInvoicesByTikect().subscribe(                  
      responseData => {                     
        
        this.ticketInvoices = responseData.body['data']

      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )

  }

  viewInvoicesByTikcket(listInvoiceExcel: any): void {

    this.listInvoiceExcel = listInvoiceExcel

  }  

  getCount(listInvoiceExcel: any): boolean {

    let isDuplicate = false
    if(listInvoiceExcel.length > 1) {
      isDuplicate = true
    }

    return isDuplicate

  }  

}
