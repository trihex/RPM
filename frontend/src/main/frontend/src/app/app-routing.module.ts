import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegistrationComponent} from "./registration/registration.component";
import {HomeComponent} from "./home/home.component";
import {TimeComponent} from "./time/time.component";
import {OutcomeComponent} from "./outcomes/outcome.compnent";
import {CaptureComponent} from "./capture/capture.component";
import {FinancialComponent} from "./financial/financial.component";

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'capture', component: CaptureComponent},
  {path: 'time', component: TimeComponent},
  {path: 'financial', component: FinancialComponent},
  {path: 'outcomes', component: OutcomeComponent},
  {path: 'register', component: RegistrationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
