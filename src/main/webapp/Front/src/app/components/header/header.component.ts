import { Component, OnInit, AfterViewInit } from '@angular/core'
import { UserModel } from 'src/app/model/user.model'
import { Router } from '@angular/router'
import * as SimpleBar from 'simplebar'
import { ActivityModel } from 'src/app/model/activity.model'

@Component({
selector: 'app-header',
templateUrl: './header.component.html',
styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, AfterViewInit {
  
    userModel = new UserModel()
    activityModel = new ActivityModel()

    constructor(private router: Router) {
  
    }

    initializeSsidebarCollapse = () => {

    }
  
    ngOnInit() {
        
        let userDetails = JSON.parse(sessionStorage.getItem('userdetails'))
        this.userModel = userDetails.data
        
    }
  
    onLogout() {

        let title = 'Sesión'
        let message = 'Sesión cerrada'
        let module = 'SYS100'

        window.sessionStorage.clear()
        this.router.navigate(['/login'])
    }
  
    ngAfterViewInit() {        
        this.initializeSidebarCollapse()
    }
    
    
    
    initializeSimplebar = () => {        
        const simplebarElementConst = document.getElementById('myElement')
        if(simplebarElementConst) {
            const simplebarInstance = new SimpleBar(simplebarElementConst)
            const sidebarDropdowns = document.querySelectorAll(".js-sidebar [data-bs-parent]")            
            sidebarDropdowns.forEach(link => {
                link.addEventListener("shown.bs.collapse", () => {
                    simplebarInstance.recalculate()
                    simplebarInstance.getContentElement()
                    simplebarInstance.unMount()
                });
                link.addEventListener("hidden.bs.collapse", () => {
                    simplebarInstance.recalculate()
                    simplebarInstance.getContentElement()
                    simplebarInstance.unMount()
                })
            })
        }
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

}