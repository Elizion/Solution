import { Component, OnInit } from '@angular/core'
import { NgForm } from '@angular/forms'
import { FormGroup } from '@angular/forms'
import { UserModel } from "src/app/model/user.model"
import { ActivityModel } from "src/app/model/activity.model"
import { UserService } from 'src/app/services/user.service'
import { AlertConstants } from 'src/app/config/alert.constants'

@Component({
  selector: 'app-user-created',
  templateUrl: './user-created.component.html',
  styleUrls: ['./user-created.component.css']
})
export class UserCreatedComponent implements OnInit {

  formGroup: FormGroup
  userCreated = new UserModel()
  userCurrent = new UserModel()
  activityModel = new ActivityModel()
  isEnabled: boolean = true
    
  constructor(private userService: UserService) { }

  ngOnInit(): void {    
    let userDetails = JSON.parse(sessionStorage.getItem('userdetails'));  
    this.userCurrent = userDetails.data as UserModel
  }

  createUser(userForm: NgForm) {    
    this.userCreated.isEnabled = this.isEnabled    
    this.userService.userCreated(this.userCreated).subscribe(      
      responseData => {               
        let response = responseData.body['data']
        console.log(response)
        let fullNameUser = response.name + ' ' + response.lastName
        alert('¡Usuario ' + fullNameUser + ' creado con exito!')
      }, error => {               
        alert(error.error.message)
      }
    )
    userForm.resetForm()
  }

}
