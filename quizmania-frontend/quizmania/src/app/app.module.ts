import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisteradminComponent } from './registeradmin/registeradmin.component';
import { RegisterexaminerComponent } from './registerexaminer/registerexaminer.component';
import { RegisterExaminerService } from './registerexaminer/registerexaminer.service';
import { RegisterExamineeService } from './registerexaminee/registerexaminee.service';
import { RegisterAdminService } from './registeradmin/registeradmin.service';
import { LoginService } from './shared/login/login.service';
import { QuizService } from './shared/quiz/quiz.service';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ExaminerDashboardComponent } from './examiner-dashboard/examiner-dashboard.component';
import { CreateQuizComponent } from './createquiz/createquiz.component';
import { PendingQuizComponent } from './pending-quiz/pending-quiz.component';
import { ApprovedQuizComponent } from './approved-quiz/approved-quiz.component';
import { ViewQuizComponent } from './viewquiz/viewquiz.component';
import { QuizStatusComponent } from './quiz-status/quiz-status.component';
import { QuizStatusNoComponent } from './quiz-status-no/quiz-status-no.component';
import { ViewQuizzesComponent } from './viewquizzes/viewquizzes.component';
import { ViewquizcategoriesComponent } from './viewquizcategories/viewquizcategories.component';
import { ViewquizBycategoryComponent } from './viewquiz-bycategory/viewquiz-bycategory.component';
import { AddQuestionsComponent } from "./addquestions/addquestions.component";
import { RegisterexamineeComponent } from './registerexaminee/registerexaminee.component';
import { ExamineeDashboardComponent } from './examinee-dashboard/examinee-dashboard.component';
import { BrowseQuizzesComponent } from './browsequizzes/browsequizzes.component';
import { BrowseQuizzesService } from './browsequizzes/browsequizzes.service';
import { ExamineeAttemptedQuizzesComponent } from './examinee-attempted-quizzes/examinee-attempted-quizzes.component';
import { ExamineeAttemptedQuizzesService } from './examinee-attempted-quizzes/examinee-attempted-quizzes.service';
import { TakeQuizComponent } from './takequiz/takequiz.component';

const appRoutes: Routes = [
  { path: '', component: LandingpageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registeradmin', component: RegisteradminComponent },
  { path: 'registerexaminer', component: RegisterexaminerComponent },
  { path: 'registerexaminee', component: RegisterexamineeComponent },
  { path: 'admin-dashboard/:userid', component: AdminDashboardComponent },
  { path: 'examinee-dashboard/:userid', component: ExamineeDashboardComponent },
  { path: 'examiner-dashboard/:userid', component: ExaminerDashboardComponent },
  { path: 'admin/:userid/viewpendingquizzes', component: PendingQuizComponent },
  { path: 'approved-quiz', component: ApprovedQuizComponent },
  { path: 'quizmania/:userid/viewquiz/:id', component: ViewQuizComponent },
  { path: ':userid/quiz-status/:id', component: QuizStatusComponent },
  { path: ':userid/quiz-status-no/:id', component: QuizStatusNoComponent },
  { path: 'examiner/:userid/createquiz', component: CreateQuizComponent },
  { path: 'examinee/:userid/browsequizzes', component: BrowseQuizzesComponent },
  { path: 'examinee/:userid/viewmyscores', component: ExamineeAttemptedQuizzesComponent },
  { path: 'examiner/:userid/viewmyquizzes', component: ViewQuizzesComponent },
  { path: 'examinee/:userid/viewcategories', component: ViewquizcategoriesComponent },
  { path: 'quizByCategory/:userid/:id', component: ViewquizBycategoryComponent },
  {
    path: "quizmania/:userid/editquiz/:id/addquestions",
    component: AddQuestionsComponent
  },
  { path: 'quizmania/:userid/takequiz/:quizid', component: TakeQuizComponent },
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
    ViewQuizComponent,
    QuizStatusComponent,
    QuizStatusNoComponent,
    ViewQuizzesComponent,
    RegisterexamineeComponent,
    ExamineeDashboardComponent,
    BrowseQuizzesComponent,
    ExamineeAttemptedQuizzesComponent,
    AddQuestionsComponent,
    ViewquizcategoriesComponent,
    ViewquizBycategoryComponent,
    TakeQuizComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    RegisterExaminerService, 
    RegisterAdminService, 
    LoginService, 
    QuizService, 
    RegisterExamineeService,
    BrowseQuizzesService,
    ExamineeAttemptedQuizzesService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
