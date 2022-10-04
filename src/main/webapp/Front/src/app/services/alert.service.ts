import { Injectable } from '@angular/core';
import { ToastrService, IndividualConfig } from 'ngx-toastr';

@Injectable()
export class AlertService {

    options: IndividualConfig;

    constructor(
        private toastr: ToastrService
    ) {
        this.options = this.toastr.toastrConfig;
        this.options.closeButton = false;
        this.options.disableTimeOut = false;
        this.options.timeOut = 3000;
        this.options.extendedTimeOut = 3000;
        this.options.enableHtml = false;
        this.options.progressBar = true;
        this.options.toastClass = 'ngx-toastr';
        this.options.positionClass = 'toast-top-center';
        this.options.titleClass = 'toast-title',
        this.options.messageClass = 'toast-message';
        this.options.easing = 'ease-in';
        this.options.easeTime = 300;
        this.options.tapToDismiss = true;
        this.options.onActivateTick = false;
        this.options.progressAnimation = 'decreasing';
    }

    showNotification(title: string, message: string, type: string) {
        this.toastr.show(message, title, this.options, 'toast-' + type);
    }

}