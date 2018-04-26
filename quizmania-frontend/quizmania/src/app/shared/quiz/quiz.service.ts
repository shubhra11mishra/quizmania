import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/toPromise";
import "rxjs/add/observable/empty";

@Injectable()
export class QuizService {
  private endURL = "";
  constructor(private http: HttpClient) {}

  getAll(userid): Observable<any> {
    console.log("in quiz service ts " + userid);
    this.endURL = "http://localhost:8080/quizmania/" + userid + "/viewQuizzes";
    console.log("done in quiz service");
    return this.http.get(this.endURL);
  }

  getAllQuestions(userid, quizid): Observable<any> {
    console.log("in quiz service ts, getting questions for quiz " + quizid);
    this.endURL =
      "http://localhost:8080/quizmania/" + userid + "/viewquiz/" + quizid;
    return this.http.get(this.endURL);
  }
}
