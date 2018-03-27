import {Headers, Http, Response} from "@angular/http";
import "rxjs/Rx";
import {EventEmitter, Injectable} from "@angular/core";
import { User } from "../user";

@Injectable()
export class LoginService{
    constructor(private http: Http) {}

    login(user: User) {
        const headers = new Headers({'Content-Type': 'application/json'});
        return this.http.post('/quizmania/login',user, {headers: headers});
}
}