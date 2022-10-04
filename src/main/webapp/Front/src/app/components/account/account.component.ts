import { Component, OnInit, AfterViewInit } from '@angular/core'
import { ActivityService } from 'src/app/services/activity.service'
import { AlertConstants } from 'src/app/config/alert.constants'
import { AlertService } from 'src/app/services/alert.service'
import { UserModel } from 'src/app/model/user.model'
import { Authenticated } from 'src/app/model/authenticated.model'
import { Authorized } from 'src/app/model/authorized.model'
import { ActivityModel } from 'src/app/model/activity.model'
import * as moment from 'moment-timezone'

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit, AfterViewInit {

  userModel = new UserModel()
  listAuthenticated: Array<Authenticated> = []
  listAuthorized: Array<Authorized> = []
  listActivity: Array<ActivityModel> = []
  timezone: string 
  locale: string = 'es-ES'
  date: moment.Moment
  createdAt: moment.Moment
  currentDate: moment.Moment

  constructor(private activityService: ActivityService, private alertService: AlertService) { 

    let userDetails = JSON.parse(sessionStorage.getItem('userdetails'))
    this.userModel = userDetails.data as UserModel

    this.listAuthenticated = this.userModel.listAuthenticated
    this.listAuthorized = this.userModel.listAuthorized
    this.timezone = JSON.parse(sessionStorage.getItem('timezone'))

    this.currentDate = moment()

    this.activityService.getAllActivities().subscribe(      
  
      responseData => {       

        let listActivities = responseData.body['data']
        this.listActivity = listActivities
        
        for(let i = 0; i<this.listActivity.length; i++) {
                              
          this.createdAt = moment(this.listActivity[i].createdAt).locale(this.locale)
          this.listActivity[i].dateString = this.createdAt.tz(this.timezone).format('YYYY-MMMM-D hh:mm:ss')
          console.log(this.listActivity[i].dateString)
    
        }
    
        console.log(this.listActivity)

      }, error => {
        
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)

      }

    ) 

  }

  ngAfterViewInit(): void {

  }

  ngOnInit(): void {

  }

}

