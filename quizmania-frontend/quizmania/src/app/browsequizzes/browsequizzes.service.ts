import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class BrowseQuizzesService {
  private endURL = '';
  constructor(private httpClient: HttpClient, private http:Http) {}
/**
  getAllApprovedQuizzes(): Observable<any> {
    this.endURL = '/quizmania/quizzes';
    return this.httpClient.get(this.endURL);
  }
*/
  takeQuiz(userID, quizID){
    const headers = new Headers({'Content-Type': 'application/json'});
    return this.http.post('/quizmania/examinee/'+userID+'/takequiz',quizID, {headers: headers});
  }

}