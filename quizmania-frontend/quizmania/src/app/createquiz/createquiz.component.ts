import { Injectable } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Quiz } from '../quiz';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable'; // Observable from rxjs library
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-createquiz',
  templateUrl: './createquiz.component.html',
  styleUrls: ['./createquiz.component.css']
})
export class CreateQuizComponent implements OnInit {
  userId = '';
  endURL = 'http://localhost:4200/quizmania/examiner/' +
    this.userId +
    '/quiz';

  category = [
    'Psychology',
    'Sociology',
    'Philosophy',
    'Arts & Culture',
    'History',
    'Geography',
    'Biology',
    'Physics',
    'Chemistry',
    'English',
    'Linguistics',
    'Engineering',
    'Computer Science!',
    'Math',
    'Statistics'
  ];

  model = new Quiz('Sample Quiz', 25, 'Psychology', 'new');

  submitted = false;
  valid = false;
  errorMsg = "";

  onSubmit(): Promise<any> {
    console.log('hmm...', this.submitted, this.valid);
    const headers = new Headers({
      'Content-Type': 'application/json'
    });

    const options = new RequestOptions({
      headers: headers
    });

    this.submitted = true;
    this.endURL =
      'http://localhost:4200/quizmania/examiner/' + this.userId + '/quiz';
    return this.http
      .post(this.endURL, this.model, options)
      .toPromise()
      .then((good: Response) => {
        console.log('good!');
        this.valid = true;
        return good.json;
      })
      .catch((error: Response | any) => {
        console.log('error!');
        console.log(error);
        return Promise.reject(error);
      });
  }

  newQuiz() {
    this.submitted = false;
    this.valid = false;
    this.model = new Quiz('Sample Quiz', 15, 'Psychology', 'new');
    // console.log('reset quiz...');
  }

  // testing...
  get diagnostic() {
    return JSON.stringify(this.model);
  }

  constructor(
    private http: Http,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  // tslint:disable-next-line:use-life-cycle-interface
  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.userId = params['userid'];
      console.log(this.userId);
    });
  }

  goBack() {
    this.endURL = '/examiner-dashboard/' + this.userId + '';
    this.router.navigate([this.endURL]);
  }
}
