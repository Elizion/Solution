import { Component, OnInit } from '@angular/core'
import { NgForm } from '@angular/forms'
import { FormGroup } from '@angular/forms'
import { UserModel } from "src/app/model/user.model"
import { ActivityModel } from "src/app/model/activity.model"
import { UserService } from 'src/app/services/user.service'
import { AlertConstants } from 'src/app/config/alert.constants'
import { AlertService } from 'src/app/services/alert.service'
import { ActivityService } from 'src/app/services/activity.service'

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
    
  constructor(private userService: UserService, private alertService: AlertService, private activityService: ActivityService) { }

  ngOnInit(): void {
    
    let userDetails = JSON.parse(sessionStorage.getItem('userdetails'));  
    this.userCurrent = userDetails.data as UserModel

  }

  createUser(userForm: NgForm) {
    
    this.userCreated.isEnabled = this.isEnabled
    
    this.userService.userCreated(this.userCreated).subscribe(      

      responseData => {               

        let response = responseData.body['data']

        let title = 'Registro'
        let message = 'Registro de usuario'
        let module = 'Usuario'
        let idUser = response.id
        let fullNameUser = this.userCurrent.name + ' ' + this.userCurrent.lastName
        
        this.generateActivity(title, message, module, idUser, fullNameUser)
        this.createActivity(this.activityModel)
        this.alertService.showNotification('¡Usuario con id ' + idUser + ' creado con exito!', response.status, AlertConstants.SUCCESS)

      }, error => {               
        this.alertService.showNotification(error.error.message, error.error.status, AlertConstants.ERROR)
      }

    )
  
    userForm.resetForm()

  }

  generateActivity(title: string, message: string, module: string, idUser: number, fullNameUser: string) {
    
    this.activityModel.title = title
    this.activityModel.message = message
    this.activityModel.module = module
    this.activityModel.idUser = idUser
    this.activityModel.fullNameUser = fullNameUser       

  }
  
  createActivity(activityModel: ActivityModel) {    

    this.activityService.createActivity(activityModel).subscribe(            
      responseData => {                     
        console.info(JSON.stringify(responseData))
      }, error => {               
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }      
    )
         
  }

}
