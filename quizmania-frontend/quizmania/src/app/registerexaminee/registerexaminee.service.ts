import {Headers, Http, Response} from "@angular/http";
import "rxjs/Rx";
import {EventEmitter, Injectable} from "@angular/core";
import { User } from "../user";

@Injectable()
export class RegisterExamineeService{
    constructor(private http: Http) {}

    registerExaminee(user: User) {
        const headers = new Headers({'Content-Type': 'application/json'});
        return this.http.post('/quizmania/examinee/register',user, {headers: headers});
}
}