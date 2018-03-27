import {Headers, Http, Response} from "@angular/http";
import "rxjs/Rx";
import {EventEmitter, Injectable} from "@angular/core";
import { User } from "../user";

@Injectable()
export class RegisterAdminService{
    constructor(private http: Http) {}

    registerAdmin(user: User) {
        const headers = new Headers({'Content-Type': 'application/json'});
        return this.http.post('/quizmania/admin/register',user, {headers: headers});
}
}