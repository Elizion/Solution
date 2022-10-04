import { BrowserModule } from '@angular/platform-browser'
import { NgModule } from '@angular/core'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule, HTTP_INTERCEPTORS, HttpClientXsrfModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module'
import { AppComponent } from './app.component'
import { XhrInterceptor } from './interceptors/app.request.interceptor'
import { AuthActivateRouteGuard } from './routeguards/auth.routeguard'
import { FeatherModule } from 'angular-feather'
import { allIcons } from 'angular-feather/icons'
import { ChartsModule } from 'ng2-charts'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { ToastrModule } from 'ngx-toastr'
import { TranslateLoader, TranslateModule } from '@ngx-translate/core'
import { TranslateHttpLoader } from '@ngx-translate/http-loader'
import { HttpClient } from '@angular/common/http'

import { HeaderComponent } from './components/header/header.component'
import { SidebarComponent } from './components/sidebar/sidebar.component'
import { LoginComponent } from './components/login/login.component'
import { DashboardComponent } from './components/dashboard/dashboard.component'
import { AccountComponent } from './components/account/account.component'
import { TestComponent } from './components/test/test.component'

import { FooterComponent } from './components/footer/footer.component'
import { UserListComponent } from './components/user/user-list/user-list.component'
import { UserCreatedComponent } from './components/user/user-created/user-created.component'

import { AlertService } from './services/alert.service'
import { ActivityService } from './services/activity.service'
import { SystemService } from './services/system.service'
import { DashboardService } from './services/dashboard.service'
import { StoreService } from './services/store.service'
import { MaterialService } from './services/material.service'
import { TicketService } from './services/ticket.service'
import { PriceService } from './services/price.service'
import { InvoiceService } from './services/invoice.service'

import { PriceListComponent } from './components/price/price-list/price-list.component';
import { StoreListComponent } from './components/store/store-list/store-list.component'

import { TicketCreatedComponent } from './components/ticket/ticket-created/ticket-created.component'
import { TicketCalculatedComponent } from './components/ticket/ticket-calculated/ticket-calculated.component';
import { TicketComparativeComponent } from './components/ticket/ticket-comparative/ticket-comparative.component';
import { TicketHistoricalComponent } from './components/ticket/ticket-historical/ticket-historical.component'

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    FooterComponent,
    LoginComponent,
    DashboardComponent,
    AccountComponent,
    TestComponent,
    UserListComponent,
    UserCreatedComponent,
    StoreListComponent,
	PriceListComponent,
    TicketCreatedComponent,
    TicketCalculatedComponent,
    TicketComparativeComponent,
    TicketHistoricalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
          useFactory: HttpLoaderFactory,
          deps: [HttpClient]
      }
    }),
    HttpClientXsrfModule.withOptions({
      cookieName: 'XSRF-TOKEN',
      headerName: 'X-XSRF-TOKEN',
    }),
    FeatherModule.pick( allIcons ),
    ChartsModule
  ],
  providers: [
    AlertService, 
    ActivityService,   
    SystemService,
    DashboardService,
    StoreService,
    MaterialService,
    TicketService,
    PriceService,
    InvoiceService,
    {
      provide : HTTP_INTERCEPTORS,
      useClass : XhrInterceptor,
      multi : true
    }, AuthActivateRouteGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
