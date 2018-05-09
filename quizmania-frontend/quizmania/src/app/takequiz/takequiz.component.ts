import { Component, OnInit, Injectable } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { QuizService } from '../shared';
import { Observable } from 'rxjs/Observable';
import { LoginService } from '../shared/login/login.service';
//import { FormControl } from '@angular/forms';
import {
  FormControlName,
  FormArray,
  FormBuilder,
  FormGroup,
} from '@angular/forms';
import { Attempt, UserResponse } from '../attempt';

@Component({
  selector: 'app-takequiz',
  templateUrl: './takequiz.component.html',
  styleUrls: ['./takequiz.component.css'],
  providers: [UserResponse],
})
@Injectable()
export class TakeQuizComponent implements OnInit {
  message: string;
  userId;
  quizId;
  endURL = '';
  quiz;
  valid = false;
  questions;
  isExaminer = false;
  isExaminee = false;
  isAdmin = false;
  notFound = false; // user is not recognized by the system

  submitted = false;
  newForm = false;
  quizForm: FormGroup;
  userResponses;
  responsesDeepCopy = [];

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private quizService: QuizService,
    private router: Router,
    private http: Http,
    private loginService: LoginService,
    private userResponse: UserResponse
  ) {
    console.log('in take quiz constructor!');
    this.createForm();
  }

  ngOnInit() {
    console.log('in take quiz ts!..');
    this.route.params.subscribe((params: Params) => {
      this.userId = params['userid'];
      this.quizId = params['quizid'];
      console.log('viewing quiz' + this.quizId + 'by user' + this.userId);
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
              console.log('got promise 1 questions');
              this.questions = data;
              console.log(
                'view quizzes ts, got quizzes for user: ' + this.userId + '!'
              );
              console.log(
                'found' +
                  this.questions.length +
                  'questions in quiz ' +
                  this.quizId
              );
              var i: number;
              for (i = this.questions.length; i >= 1; i--) {
                this.responses.push(
                  this.fb.group(this.userResponse.makeNewResponse(''))
                );
              }
              this.quizService.getQuizById(this.quizId).subscribe(
                data2 => {
                  console.log('got quiz details to display!');
                  this.quiz = data2;
                },
                error => console.log('E1' + error)
              );
            },
            error2 => console.log('E2' + error2)
          );
        },
        error3 => console.log('E3' + error3)
      );
    });
  }

  createForm() {
    this.newForm = true;
    this.submitted = false;
    this.quizForm = this.fb.group({
      responses: this.fb.array([]),
    });
  }

  get responses(): FormArray {
    return this.quizForm.get('responses') as FormArray;
  }

  prepareSaveAttempt() {
    const formValues = this.quizForm.value;

    /**
    const responsesDeepCopy: UserResponse[] = formValues.responses.map(
      (resp: UserResponse) => Object.assign({}, resp)
    );
    */
    var i: number;
    for (i = 0; i < this.questions.length; i++) {
      const str = formValues.responses[i]['resp'];
      console.log(str);
      this.responsesDeepCopy.push(str);
    }

    // const resps = JSON.stringify(this.responsesDeepCopy2);
    // console.log('Yo: ' + this.responsesDeepCopy2.toString());
    // console.log('Here is what we got:' + resps);
    console.log('Finally: ' + this.responsesDeepCopy.toString());
    //return this.responsesDeepCopy;
  }

  onSubmit() {
    this.userResponses = this.prepareSaveAttempt();
    this.submitted = true;
    console.log('hmm...grading attempt');
    const headers = new Headers({
      'Content-Type': 'application/json',
    });

    const options = new RequestOptions({
      headers: headers,
    });
    this.newForm = false;
    this.endURL =
      'http://localhost:4200/quizmania/examinee/' +
      this.userId +
      '/takequiz/' +
      this.quizId;
    return this.http
      .post(this.endURL, this.responsesDeepCopy, options)
      .toPromise()
      .then((good: Response) => {
        console.log('graded attempt!');
        if (good === null) {
          this.message = 'Unknown user and/or quiz! ';
          console.log('bad attempt. Data is null');
        }

        /** 
        console.log('re-directing user...');
        this.endURL = 'http://localhost:8080/examiner-dashboard/' + this.userId;
        console.log('done in take quiz ts');
        return this.http.get(this.endURL);
        */
      })
      .catch((error: Response | any) => {
        console.log('hmm error grading attempt :(');
        console.log(error);
        return Promise.reject(error);
      });
  }

  goBack(pageCode) {
    if (pageCode == 1) {
      this.endURL = '/examinee/' + this.userId + '/browsequizzes';
      this.router.navigate([this.endURL]);
    } else if (pageCode == 2) {
      this.endURL = '/examinee-dashboard/' + this.userId + '';
      this.router.navigate([this.endURL]);
    } else if (pageCode == 3) {
      this.endURL = '/examinee/' + this.userId + '/myscores';
      this.router.navigate([this.endURL]);
    }
  }
}
