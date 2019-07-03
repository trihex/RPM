import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ColumnComponent} from "./datatable/column.component";
import {DatatableComponent} from "./datatable/datatable.component";
import {RegistrationComponent} from "./registration/registration.component";
import {HomeComponent} from "./home/home.component";
import {TimeComponent} from "./time/time.component";
import {UserComponent} from "./user/user.component";
import {OutcomeComponent} from "./outcomes/outcome.compnent";
import {CaptureComponent} from "./capture/capture.component";
import {FinancialComponent} from "./financial/financial.component";
import {FormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {UserService} from "./user/user.service";
import {AngularWebStorageModule} from "angular-web-storage";

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    HomeComponent,
    CaptureComponent,
    FinancialComponent,
    RegistrationComponent,
    TimeComponent,
    OutcomeComponent,
    DatatableComponent,
    ColumnComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AngularWebStorageModule,
    NgbModule
  ],
  providers: [UserService, HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule {
}
