import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ExamineeAttemptedQuizzesService {
  private endURL = '';
  constructor(private http: HttpClient) {}

  getAllAttemptedQuizzes(userId): Observable<any> {
    this.endURL = '/quizmania/examinee/' + userId + '/viewAttemptedQuizzes';
    return this.http.get(this.endURL);
  }

}