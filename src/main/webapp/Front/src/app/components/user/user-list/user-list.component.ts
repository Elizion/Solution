import { Component, OnInit } from '@angular/core'
import { UserModel } from 'src/app/model/user.model'
import { UserService } from 'src/app/services/user.service'
import * as moment from 'moment-timezone'
import { ChartType } from 'chart.js'
import { Label, MultiDataSet, Color } from 'ng2-charts'
import { AlertService } from 'src/app/services/alert.service'
import { AlertConstants } from 'src/app/config/alert.constants'

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  listUser: Array<UserModel> = []
  userModel: UserModel
  currentTime: Date
  tzDate: moment.Moment
  strDate: string
  timezone: string

  doughnutChartLabels: Label[]
  doughnutChartColors: Color[]
  doughnutChartType: ChartType
  doughnutChartData: MultiDataSet 

  constructor(private userService: UserService, private alertService: AlertService) {
    this.doughnutChartData = [this.getUserActives()] as MultiDataSet
    this.doughnutChartLabels = ['Activos','Inactivos'] as Label[]
    this.doughnutChartColors = [{ backgroundColor: ["#145A32", "#DC3545"] }] as Color[]
    this.doughnutChartType = 'doughnut' as ChartType
    this.initializeSidebarCollapse()
  }

  ngOnInit(): void {        
    this.timezone = JSON.parse(sessionStorage.getItem('timezone'))    
    let myModal = document.getElementById('modalModifiedUser')    
    myModal.addEventListener('shown.bs.modal', function () {
      myModal.focus()
    })
  }

initializeSidebarCollapse() {
      const sidebarElement = document.getElementsByClassName("js-sidebar")[0]
      const sidebarToggleElement = document.getElementsByClassName("js-sidebar-toggle")[0]
      if (sidebarElement && sidebarToggleElement) {
        sidebarToggleElement.addEventListener("click", () => {
            sidebarElement.classList.toggle("collapsed")
            sidebarElement.addEventListener("transitionend", () => {
                window.dispatchEvent(new Event("resize"))
            })
        })
    }
}
  modifiedUserByEmail(userModel: UserModel): void {    
    this.userModel = userModel
  }

  desactivatedUserByEmail(email: string): void {    
    this.userService.desactivatedUserByEmail(email).subscribe(      
      responseData => {             
        this.alertService.showNotification(responseData['data'], 'Success', AlertConstants.SUCCESS)
        this.getUserActives()
      }, error => {
        this.alertService.showNotification(error.error.message, 'Error', AlertConstants.ERROR)
      }
    )  
  }

  activatedUserByEmail(email: string): void {    
    this.userService.activatedUserByEmail(email).subscribe(      
      responseData => {             
        this.alertService.showNotification(responseData['data'], 'Success', AlertConstants.SUCCESS)
        this.getUserActives()
      }, error => {
        this.alertService.showNotification(error.error.message, 'Error', AlertConstants.ERROR)
      }
    )  
  }

  getUserActives(): Array<number> {    
    let x = 0
    let y = 0
    const formatDate = 'DD MMM YYYY'
    let chartData: Array<number> = []    
    this.userService.getUserActives().subscribe(      
      responseData => {     
        this.listUser = responseData.body['data']        
        for(let i = 0; i<this.listUser.length; i++) {          
          this.currentTime = this.listUser[i].bornDate
          this.tzDate = moment(this.currentTime).tz(this.timezone)
          this.strDate = this.tzDate.format(formatDate)
          this.listUser[i].bornStrDate = this.strDate          
          if(this.listUser[i].codeStatus === 'SYS001') {
            x++
          } else if(this.listUser[i].codeStatus === 'SYS000') {
            y++
          }
        }        
        chartData.push(x)
        chartData.push(y)          
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )  
    this.doughnutChartData = [chartData] as MultiDataSet
    return chartData
  }
  
}


