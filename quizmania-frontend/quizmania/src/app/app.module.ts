import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HttpModule } from "@angular/http";
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
import { ExaminerDashboardComponent } from './createquiz/examiner-dashboard/examiner-dashboard.component';
import { CreateQuizComponent } from './createquiz/createquiz.component';
import { PendingQuizComponent } from './pending-quiz/pending-quiz.component';
import { ApprovedQuizComponent } from './approved-quiz/approved-quiz.component';
import { ViewQuestionComponent } from './view-question/view-question.component';
import { QuizStatusComponent } from './quiz-status/quiz-status.component';
import { QuizStatusNoComponent } from './quiz-status-no/quiz-status-no.component';
import { ViewQuizzesComponent } from './viewquizzes/viewquizzes.component';


const appRoutes: Routes = [
  { path:'',component:LandingpageComponent },
  { path:'login', component:LoginComponent },
  { path:'registeradmin', component:RegisteradminComponent},
  { path:'registerexaminer', component:RegisterexaminerComponent},
  { path:'admin-dashboard', component:AdminDashboardComponent},
  { path:'examiner-dashboard', component:ExaminerDashboardComponent},
  { path:'pending-quiz', component:PendingQuizComponent},
  { path:'approved-quiz', component:ApprovedQuizComponent},
  { path:'view-question/:id', component:ViewQuestionComponent},
  { path:'quiz-status/:id', component:QuizStatusComponent},
  { path:'quiz-status-no/:id', component:QuizStatusNoComponent}, 
  { path:'examiner/createquiz', component:CreateQuizComponent}, 
  { path:'examiner/viewquizzes', component:ViewQuizzesComponent}, 
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
    CreateQuizComponent,
    PendingQuizComponent,
    ApprovedQuizComponent,
    ViewQuestionComponent,
    QuizStatusComponent,
    QuizStatusNoComponent,
    ViewQuizzesComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
  ],
  providers: [RegisterExaminerService, RegisterAdminService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
