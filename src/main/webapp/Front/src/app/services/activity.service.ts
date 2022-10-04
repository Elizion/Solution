import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { ActivityModel } from "../model/activity.model"
import { ApiConstants } from "../config/api.constants"
import { environment } from '../../environments/environment'

@Injectable()
export class ActivityService {

    constructor(private http: HttpClient) { }

    createActivity(activityModel : ActivityModel) {  
        return this.http.post(environment.rooturl + ApiConstants.URI_ACTIVITY_CREATED, activityModel, { observe: 'response' });    
    }

    getAllActivities() {
        return this.http.get(environment.rooturl + ApiConstants.URI_ACTIVITY_GET_ALL, { observe: 'response', withCredentials: true })
    }

}