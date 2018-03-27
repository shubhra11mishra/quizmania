import {Headers, Http, Response} from "@angular/http";
import "rxjs/Rx";
import {EventEmitter, Injectable} from "@angular/core";
import { User } from "../user";

@Injectable()
export class RegisterExaminerService{
    constructor(private http: Http) {}

    registerExaminer(user: User) {
        const headers = new Headers({'Content-Type': 'application/json'});
        return this.http.post('/quizmania/examiner/register',user, {headers: headers});
}
}