import { Component, OnInit, Injectable } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { QuizService } from '../shared';
import { Observable } from 'rxjs/Observable';
import { LoginService } from '../shared/login/login.service';
import { Comment } from './commentModel';

@Component({
  selector: 'app-viewquiz',
  templateUrl: './viewquiz.component.html',
  styleUrls: ['./viewquiz.component.css'],
})
@Injectable()
export class ViewQuizComponent implements OnInit {
  /** The following three vars are to indicate user type based on url */
  isAdmin = false;
  isExaminee = false;
  isExaminer = false;

  /** The following three variables depend on the front-end user input (which buttons are pressed) */
  quizActionApprove = false;
  quizActionReject = false;
  actionPending = true;

  userId;
  quizId;
  endURL = '';
  quiz;
  notFound = true;
  /** used in goBack() in front-end to redirect user to appropriate page based on their user type */
  examinee = 'examinee';
  examiner = 'examiner';
  admin = 'admin';

  /** Used for ng model form */
  model = new Comment('');

  /** The following three variables are set once the admin "SUBMITS" comments for approving/rejecting quiz */
  submitted = false;
  quizApproved = false;
  quizRejected = false;

  // quizzes: Array<any>;
  questions;
  constructor(
    private route: ActivatedRoute,
    private quizService: QuizService,
    private router: Router,
    private http: Http,
    private loginService: LoginService
  ) {}

  ngOnInit() {
    console.log('in view quiz ts!..');
    this.route.params.subscribe((params: Params) => {
      this.userId = params['userid'];
      this.quizId = params['id'];
      console.log('viewing quiz by user ' + this.userId);
      this.loginService.getUser(this.userId).subscribe(
        response => {
          if (response.json().email === null) {
            console.log('user not found!');
            // to do!!!
            this.notFound = true;
          } else {
            console.log(response.json().userType);
            if (response.json().userType === 'ADMIN') {
              console.log('admin is logged in');
              this.isAdmin = true;
            } else if (response.json().userType === 'EXAMINER') {
              console.log('examiner is logged in');
              this.isExaminer = true;
            } else if (response.json().userType === 'EXAMINEE') {
              console.log('examinee is logged in');
              this.isExaminee = true;
            }
          }
          this.quizService.getAllQuestions(this.userId, this.quizId).subscribe(
            data => {
              console.log(data);
              this.questions = data;
              console.log(
                'view quizzes ts, got quizzes for user: ' + this.userId + '!'
              );
              this.quizService.getQuizById(this.quizId).subscribe(
                data => {
                  console.log('got quiz details to display!');
                  this.quiz = data;
                },
                error => console.log(error)
              );
            },
            error2 => console.log(error2)
          );
        },
        error3 => console.log(error3)
      );
    });
  }

  goBack(userType) {
    console.log('here...');
    if (userType === 'admin') {
      this.endURL = '/admin/' + this.userId + '/viewpendingquizzes';
    } else if (userType === 'examiner') {
      this.endURL = '/examiner/' + this.userId + '/viewmyquizzes';
    } else if (userType === 'examinee') {
      // to do!!!
      this.endURL = '/examinee-dashboard/' + this.userId + '';
    } else {
      console.log('null user?');
    }
    this.router.navigate([this.endURL]);
  }

  onApprove() {
    this.quizActionApprove = true;
    this.actionPending = false;
  }

  onReject() {
    this.quizActionReject = true;
    this.actionPending = false;
  }

  cancelAction() {
    this.quizActionApprove = false;
    this.quizActionReject = false;
    this.actionPending = true;
  }

  onSubmit() {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    this.submitted = true;
    const options = new RequestOptions({ headers: headers });
    if (this.quizActionApprove == true) {
      if (this.model.comment === null || this.model.comment.trim.length === 0) {
        this.model.comment = 'good!';
      }
      this.quizApproved = true;
      this.endURL =
        'http://localhost:4200/quizmania/quiz/' + this.quizId + '/approve';
    } else if (this.quizActionReject == true) {
      this.quizRejected = true;
      this.endURL =
        'http://localhost:4200/quizmania/quiz/' + this.quizId + '/reject';
    } else {
      console.log('no action chosen!');
    }
    return this.http
      .post(this.endURL, this.model.comment, options)
      .toPromise()
      .then((good: Response) => {
        console.log('posted quiz status updates.');
      })
      .catch((error: Response | any) => {
        console.log('error!');
        console.log(error);
        return Promise.reject(error);
      });
  }

  approve() {
    this.endURL = this.userId + '/quiz-status/' + this.quizId + '';
    this.router.navigate([this.endURL]);
    console.log('approve...quiz ' + this.quizId + ' for user ' + this.userId);
  }

  reject() {
    this.endURL = this.userId + '/quiz-status-no/' + this.quizId + '';
    this.router.navigate([this.endURL]);
    console.log('reject...quiz ' + this.quizId + ' for user ' + this.userId);
  }

  get diagnostic() {
    return JSON.stringify(this.model);
  }
}
