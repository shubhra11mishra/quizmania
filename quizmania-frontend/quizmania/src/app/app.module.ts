import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import {HttpModule} from "@angular/http";
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisteradminComponent } from './registeradmin/registeradmin.component';
import { RegisterexaminerComponent } from './registerexaminer/registerexaminer.component';
import { RegisterExaminerService } from './registerexaminer/registerexaminer.service';

import { RegisterAdminService } from './registeradmin/registeradmin.service';
import { LoginService } from './login/login.service';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ExaminerDashboardComponent } from './examiner-dashboard/examiner-dashboard.component';
import { CreatequizComponent } from './createquiz/createquiz.component';
import { PendingQuizComponent } from './pending-quiz/pending-quiz.component';
import { ApprovedQuizComponent } from './approved-quiz/approved-quiz.component';
import { ViewQuestionComponent } from './view-question/view-question.component';
import { QuizStatusComponent } from './quiz-status/quiz-status.component';
import { QuizStatusNoComponent } from './quiz-status-no/quiz-status-no.component';





const appRoutes: Routes = [
  { path:'',component:LandingpageComponent },
  {  path:'login', component:LoginComponent },
  { path:'registeradmin', component:RegisteradminComponent},
  { path:'registerexaminer', component:RegisterexaminerComponent},
  { path:'admin-dashboard', component:AdminDashboardComponent},
  { path:'examiner-dashboard', component:ExaminerDashboardComponent},
  { path:'pending-quiz', component:PendingQuizComponent},
  { path:'approved-quiz', component:ApprovedQuizComponent},
  { path:'view-question/:id', component:ViewQuestionComponent},
  { path:'quiz-status/:id', component:QuizStatusComponent},
  { path:'quiz-status-no/:id', component:QuizStatusNoComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisteradminComponent,
    RegisterexaminerComponent,
    LandingpageComponent,
    AdminDashboardComponent,
    ExaminerDashboardComponent,
    CreatequizComponent,
    PendingQuizComponent,
    ApprovedQuizComponent,
    ViewQuestionComponent,
    QuizStatusComponent,
    QuizStatusNoComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [RegisterExaminerService, RegisterAdminService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
