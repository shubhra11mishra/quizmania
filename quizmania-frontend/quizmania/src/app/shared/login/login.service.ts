import { Headers, Http, Response } from "@angular/http";
import { EventEmitter, Injectable } from "@angular/core";
import { User } from "../../user";
import { Observable } from "rxjs/Observable";

@Injectable()
export class LoginService {
  endURL = "";

  constructor(private http: Http) {}

  login(user: User) {
    const headers = new Headers({ "Content-Type": "application/json" });
    return this.http.post("/quizmania/login", user, { headers: headers });
  }

  getUserPost(userID) {
    const headers = new Headers({ "Content-Type": "application/json" });
    return this.http.post("/quizmania/getUser", userID, { headers: headers });
  }

  getUser(userID): Observable<any> {
    console.log("getting user, login service ts");
    this.endURL = "http://localhost:8080/quizmania/user/" + userID;
    console.log(this.endURL);
    return this.http.get(this.endURL);
  }

}
