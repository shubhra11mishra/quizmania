import {Headers, Http, Response} from "@angular/http";
import "rxjs/Rx";
import {EventEmitter, Injectable} from "@angular/core";
import { Quiz } from "../quiz";

@Injectable()
export class CreateQuizService{
    constructor(private http: Http) {}

    createQuiz(quiz: Quiz) {
        const headers = new Headers({'Content-Type': 'application/json'});
        return this.http.post('/quizmania/examiner/createquiz', quiz, {headers: headers});
}
}