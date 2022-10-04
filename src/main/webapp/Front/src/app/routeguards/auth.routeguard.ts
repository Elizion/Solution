import { ConstantPool } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot,Router } from '@angular/router';
import { UserModel } from '../model/user.model';

@Injectable()
export class AuthActivateRouteGuard implements CanActivate {

    userModel = new UserModel();
    
    constructor(private router: Router) {

    }

    canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot) {
        
        console.info('Route ' + route.routeConfig.path + 'State ' + state);

        this.userModel = JSON.parse(sessionStorage.getItem('userdetails'));
        
        if(!this.userModel) {
            this.router.navigate(['login']);
        }

        return this.userModel ? true: false;

    }

}