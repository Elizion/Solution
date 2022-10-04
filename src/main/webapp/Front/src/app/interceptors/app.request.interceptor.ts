import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { tap } from 'rxjs/operators';
import { UserModel } from 'src/app/model/user.model';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  userModel = new UserModel();
  constructor(private router: Router) {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    
    let httpHeaders = new HttpHeaders()

    this.userModel = JSON.parse(sessionStorage.getItem('userdetails'))

    if(this.userModel && this.userModel.password && this.userModel.email) {
      httpHeaders = httpHeaders.append('Authorization', 'Basic ' + btoa(this.userModel.email + ':' + this.userModel.password))
    }
  
    let authorization = sessionStorage.getItem('Authorization')
    
    if(authorization){
      httpHeaders = httpHeaders.append('Authorization', authorization)
    }
    
    httpHeaders = httpHeaders.append('X-Requested-With', 'XMLHttpRequest')
    
    const xhr = req.clone({
      headers: httpHeaders
    })

  return next.handle(xhr).pipe(tap(() => {},
    (err: any) => {
      if (err instanceof HttpErrorResponse) {
        if (err.status !== 401) {
          return
        }
        this.router.navigate(['dashboard'])
      }
    }))
  }
  
}