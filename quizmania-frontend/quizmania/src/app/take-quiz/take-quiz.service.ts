import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class TakeQuizService {
  private endURL = '';
  constructor(private http: HttpClient, private http1:Http) {}

  getAllApprovedQuizzes(): Observable<any> {
    this.endURL = '/quizmania/quizzes';
    return this.http.get(this.endURL);
  }

  takeQuiz(userID, quizID){
    const headers = new Headers({'Content-Type': 'application/json'});
    return this.http1.post('/quizmania/examinee/'+userID+'/takequiz',quizID, {headers: headers});
  }

}