import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class QuizService {
  private endURL = '';
  constructor(private http: HttpClient) {}

  getAll(userid): Observable<any> {
    console.log('in quiz service ts ' + userid);
    this.endURL = 'http://localhost:8080/quizmania/' + userid + '/viewQuizzes';
    return this.http.get(this.endURL);
  }

  getAllQuestions(userid, quizid): Observable<any> {
    console.log('in quiz service ts, getting questions for quiz ' + quizid);
    this.endURL = 'http://localhost:8080/quizmania/' + userid + '/viewquiz/' + quizid;
    return this.http.get(this.endURL);
  }

  getQuizCategories(): Observable<any> {
    console.log('getting quizcategories');
    this.endURL = 'http://localhost:8080/quizmania/examinee/quizCategories/';
    return this.http.get(this.endURL);
  }
  getQuizByCategory(quizId): Observable<any> {
    console.log('getting quizzess');
    this.endURL = 'http://localhost:8080/quizmania/quizByCategory/'+quizId;
    return this.http.get(this.endURL);
  }

}
