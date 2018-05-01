import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class QuizService {
  private endURL = '';
  constructor(private http: HttpClient) {}

  // gets all quizzes depending on user id and type
  getAll(userid): Observable<any> {
    console.log('in quiz service ts ' + userid);
    this.endURL = 'http://localhost:8080/quizmania/' + userid + '/viewQuizzes';
    console.log('done in quiz service');
    return this.http.get(this.endURL);
  }

  // returns question for given quiz
  getAllQuestions(userid, quizid): Observable<any> {
    console.log('in quiz service ts, getting questions for quiz ' + quizid);
    this.endURL =
      'http://localhost:8080/quizmania/' + userid + '/viewquiz/' + quizid;
    return this.http.get(this.endURL);
  }

  updateQuiz(userId, quizid, questions): Observable<any> {
    console.log('to do :)');
    this.endURL = 'http://localhost:8080/quizmania/' + userId + '/viewQuizzes';
    console.log('done in quiz service');
    return this.http.get(this.endURL);
  }

  getQuizCategories(): Observable<any> {
    console.log('getting quizcategories');
    this.endURL = 'http://localhost:8080/quizmania/examinee/quizCategories/';
    return this.http.get(this.endURL);
  }

  getQuizByCategory(quizId): Observable<any> {
    console.log('getting quizzess');
    this.endURL = 'http://localhost:8080/quizmania/quizByCategory/' + quizId;
    return this.http.get(this.endURL);
  }

  getQuizById(quizId): Observable<any> {
    console.log('finding quiz to display...');
    this.endURL = 'http://localhost:8080/quizmania/' + quizId;
    return this.http.get(this.endURL);
  }

  takeQuiz(userID, quizID){
    const headers = new Headers({'Content-Type': 'application/json'});
    //return this.http.post('/quizmania/examinee/'+userID+'/takequiz',quizID, {headers: headers});
    this.endURL = 'quizmania/' + userID + '/viewquiz/' + quizID;
    return this.http.get(this.endURL);
  }

}
