import { Component, OnInit, AfterViewInit } from '@angular/core'
import { AlertConstants } from 'src/app/config/alert.constants'
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

  constructor() { 

    let userDetails = JSON.parse(sessionStorage.getItem('userdetails'))
    this.userModel = userDetails.data as UserModel

    this.listAuthenticated = this.userModel.listAuthenticated
    this.listAuthorized = this.userModel.listAuthorized
    this.timezone = JSON.parse(sessionStorage.getItem('timezone'))

    this.currentDate = moment()

  }

  ngAfterViewInit(): void {

  }

  ngOnInit(): void {

  }

}

