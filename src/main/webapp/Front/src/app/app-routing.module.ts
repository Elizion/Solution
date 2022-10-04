import { NgModule } from '@angular/core'
import { Routes, RouterModule } from '@angular/router'
import { LoginComponent } from './components/login/login.component'
import { DashboardComponent } from './components/dashboard/dashboard.component'
import { AuthActivateRouteGuard } from './routeguards/auth.routeguard'
import { AccountComponent } from './components/account/account.component'
import { NotFoundComponent } from './components/error/not-found/not-found.component'
import { UserListComponent } from './components/user/user-list/user-list.component'
import { UserCreatedComponent } from './components/user/user-created/user-created.component'
import { StoreListComponent } from './components/store/store-list/store-list.component'
import { TicketCreatedComponent } from './components/ticket/ticket-created/ticket-created.component'
import { TicketCalculatedComponent } from './components/ticket/ticket-calculated/ticket-calculated.component'
import { TicketComparativeComponent } from './components/ticket/ticket-comparative/ticket-comparative.component'
import { TicketHistoricalComponent } from './components/ticket/ticket-historical/ticket-historical.component'
import { TestComponent } from './components/test/test.component'

const routes: Routes = [

  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'account', component: AccountComponent, canActivate: [AuthActivateRouteGuard]},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AuthActivateRouteGuard]},
  {path: 'user/created', component: UserCreatedComponent, canActivate: [AuthActivateRouteGuard]},
  {path: 'user/list', component: UserListComponent, canActivate: [AuthActivateRouteGuard]},
  {path: 'store/list', component: StoreListComponent, canActivate: [AuthActivateRouteGuard]},
  {path: 'ticket/created', component: TicketCreatedComponent, canActivate: [AuthActivateRouteGuard]},
  {path: 'ticket/historical', component: TicketHistoricalComponent, canActivate: [AuthActivateRouteGuard]},
  {path: 'ticket/calculated', component: TicketCalculatedComponent, canActivate: [AuthActivateRouteGuard]},
  {path: 'ticket/comparative', component: TicketComparativeComponent, canActivate: [AuthActivateRouteGuard]},
  {path: 'test', component: TestComponent},
  {path: '**', component: NotFoundComponent}

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
