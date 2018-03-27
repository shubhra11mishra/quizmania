import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisteradminComponent } from './registeradmin/registeradmin.component';
import { RegisterexaminerComponent } from './registerexaminer/registerexaminer.component';
import { RegisterExaminerService } from './registerexaminer/registerexaminer.service';
import { HttpModule } from '@angular/http';
import { RegisterAdminService } from './registeradmin/registeradmin.service';
import { LoginService } from './login/login.service';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ExaminerDashboardComponent } from './examiner-dashboard/examiner-dashboard.component';

const appRoutes: Routes = [
  { path:'',component:LandingpageComponent },
  {  path:'login', component:LoginComponent },
  { path:'registeradmin', component:RegisteradminComponent},
  { path:'registerexaminer', component:RegisterexaminerComponent},
  { path:'admin-dashboard', component:AdminDashboardComponent},
  { path:'examiner-dashboard', component:ExaminerDashboardComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisteradminComponent,
    RegisterexaminerComponent,
    LandingpageComponent,
    AdminDashboardComponent,
    ExaminerDashboardComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpModule
  ],
  providers: [RegisterExaminerService, RegisterAdminService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
