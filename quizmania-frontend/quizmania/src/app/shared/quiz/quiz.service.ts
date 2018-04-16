import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class QuizService {
	private endURL = "";
  constructor(private http: HttpClient) {}

  getAll(userid): Observable<any> {
  	this.endURL = 'http://localhost:8080/quizmania/' + userid + '/viewQuizzes';
    return this.http.get(this.endURL);
  }
}
