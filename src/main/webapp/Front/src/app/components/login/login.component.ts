import { Component, OnInit } from '@angular/core'
import { NgForm } from '@angular/forms'
import { Router } from '@angular/router'
import * as moment from 'moment-timezone'
import { interval, Subscription } from 'rxjs'
import { ActivityModel } from 'src/app/model/activity.model'
import { UserModel } from 'src/app/model/user.model'
import { DateModel } from 'src/app/model/date.model'

import { CONFIG } from '../../config/config.constants'
import { AlertConstants } from 'src/app/config/alert.constants'

import { TranslateService } from '@ngx-translate/core'
import { LoginService } from 'src/app/services/login.service'
import { SystemService } from 'src/app/services/system.service'
import { AlertService } from 'src/app/services/alert.service'
import { ActivityService } from 'src/app/services/activity.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  userModel = new UserModel()
  dateModel = new DateModel()
  activityModel = new ActivityModel()

  tzNames: string[]
  selectedTz: string
  tzDate: moment.Moment
  strDate: string
  
  updateSubscription: Subscription

  constructor(
    private translate: TranslateService,
    private loginService: LoginService,
    private systemService: SystemService,
    private activityService: ActivityService,
    private alertService: AlertService,
    private router: Router
  ) {
      
      this.translate.addLangs([CONFIG.LANG_EN, CONFIG.LANG_ES])
      this.translate.setDefaultLang(CONFIG.LANG_ES)
      this.translate.use(CONFIG.LANG_ES)

      this.tzNames = moment.tz.names()
      this.timeZoneChanged(CONFIG.TIME_ZONE_PIVOT)
      this.getDateSystem(this.selectedTz)

  }
  
  ngOnInit(): void {

    this.updateSubscription = interval(60000).subscribe(
      (val) => { 
        this.getDateSystem(this.selectedTz)
      }
    )
    
  }
  
  timeZoneChanged(timeZone: string): void {
    this.selectedTz = timeZone
  }

  startSignin(loginForm: NgForm): void {    
    
    this.loginService.startSignin(this.userModel).subscribe(

      responseData => {

        this.userModel = responseData.body as UserModel
        
        window.sessionStorage.setItem('Authorization', responseData.headers.get('Authorization'))
        window.sessionStorage.setItem('userdetails', JSON.stringify(this.userModel))
        window.sessionStorage.setItem('timezone', JSON.stringify(this.selectedTz))
        
        let title = 'Sesión'
        let message = 'Sesión establecida'
        let module = 'SYS100'
        
        let userDetails = JSON.parse(sessionStorage.getItem('userdetails'))
        
        this.generateActivity(title, message, module, userDetails.data)
        this.createActivity(this.activityModel)

        loginForm.resetForm()
        this.router.navigate(['dashboard'])

      }, error => {        

        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
        this.router.navigate(['login'])

      }

    )

  }

  generateActivity(title: string, message: string, module: string, userModel: UserModel) {
    
    let idUser = userModel.id
    let fullNameUser = userModel.name + ' ' + userModel.lastName  
      
    this.activityModel.title = title
    this.activityModel.message = message
    this.activityModel.module = module
    this.activityModel.idUser = idUser
    this.activityModel.fullNameUser = fullNameUser       

  }
  
  createActivity(activityModel: ActivityModel) {    

    this.activityService.createActivity(activityModel).subscribe(            
      responseData => {                     
        console.info(responseData.body)
      }, error => {               
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }      
    )
         
  }

  getDateSystem(selectedTz: string): void {
    
    this.systemService.getDateSystem(selectedTz).subscribe(      
      
      responseData => {     
        
        this.dateModel = responseData['data']
        this.dateModel.isValidateDate = moment(this.dateModel.date).isValid()        

        if(this.dateModel.isValidateDate) {
          let d5 = moment(this.dateModel.date).tz(selectedTz).format('YYYY-MMM-DD HH:mm:ss')
          let myDate: Date = moment(d5,'YYYY-MMM-DD HH:mm:ss').toDate()
          this.dateModel.date = myDate
        }

        console.log(this.dateModel)
        
      }, error => {
    
        console.error(error.error.message)
    
      }
    )

  }

  getCookie(name: any): void {
    const cookie = {}
    document.cookie.split(';').forEach(function(el: any): any {
      const [ k, v ] = el.split('=')
      cookie[k.trim()] = v
    })
    return cookie[name]
  }

}
