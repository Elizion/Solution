import { Component, OnInit } from '@angular/core';
import { UserModel } from 'src/app/model/user.model';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  
  constructor() { }
  
  userModel = new UserModel()

  ngOnInit(): void {
    let userDetails = JSON.parse(sessionStorage.getItem('userdetails'))
    this.userModel = userDetails.data
  }

  ngAfterViewInit() {    
    const sidebarItem = document.getElementsByClassName("sidebar-item")[0]
    sidebarItem.addEventListener("click", () => {
      console.log('Ok')
    })
  }

}