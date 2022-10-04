import { Component, OnInit } from '@angular/core'
import * as moment from 'moment-timezone'

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  currentTime: string
  tzDate: moment.Moment
  strDate: string
  timezone: string

  constructor() { }

  ngOnInit(): void {
    
    const formatDate = 'DD MMM YYYY HH:mm:ss z'
    this.timezone = JSON.parse(sessionStorage.getItem('timezone'))
    
    setInterval(() => {
  
      const currentTime = new Date().getTime()
      this.tzDate = moment(currentTime).tz(this.timezone)
      this.strDate = this.tzDate.format(formatDate)

    }, 1000)

  }
 

}
