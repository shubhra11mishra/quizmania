import { Injectable } from "@angular/core";
import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { Quiz } from "../quiz";
import { Http, Response, RequestOptions, Headers } from "@angular/http";
import { Observable } from "rxjs/Observable"; // Observable from rxjs library
import { QuizService } from "../shared";

@Component({
  selector: "app-pending-quiz",
  templateUrl: "./pending-quiz.component.html",
  styleUrls: ["./pending-quiz.component.css"],
  providers: [QuizService]
})
@Injectable()
export class PendingQuizComponent implements OnInit {
  quizzes: Array<any>;
  userId = "";
  endURL = "";
  message = "";

  constructor(
    private quizService: QuizService,
    private httpClient: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.message = null;
    // To-Do!!! Pass in admin user id
    this.route.params.subscribe((params: Params) => {
      this.userId = params["userid"];
      console.log(this.userId);
      // get the type of user for appropriate header
      // To-Do!!!
      this.quizService.getAll(params["userid"]).subscribe(
        data => {
          if (data === null) {
            this.message =
              "Unauthorized attempt to view pending quizzes. Please login before proceeding.";
            console.log("data is null");
          } else if (data.length === 0) {
            console.log("No pending quizzes");
          } else {
            console.log("got quizzes from quiz service");
            this.quizzes = data;
            console.log("got quizzes!");
          }
          // console.log(this.quizzes)
        },
        error => {
          console.log(error);
        }
      );
    });
  }

  reviewQuiz(quizID) {
    console.log("review quiz " + quizID);
    this.endURL = "/quizmania/" + this.userId + "/viewquiz/" + quizID;
    this.router
      .navigate([this.endURL])
      .then(good => {
        console.log("great pending quiz, clicked button");
      })
      .catch(err => {
        console.log("error in pending quiz ts..");
        console.log(err);
      });
  }

  goBack() {
    console.log("here...");
    this.endURL = "/admin-dashboard/" + this.userId + "";
    this.router.navigate([this.endURL]);
  }
}
