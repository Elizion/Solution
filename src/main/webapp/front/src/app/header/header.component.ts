import { Component } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-header-component',
    encapsulation: ViewEncapsulation.None,
    templateUrl: './header.component.html'
})
export class HeaderComponent{
    constructor(public router: Router) {
        
    }
}
