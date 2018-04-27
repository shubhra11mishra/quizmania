import { Component, OnInit } from "@angular/core";
import { Params, ActivatedRoute, Router } from "@angular/router";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

@Component({
  selector: "app-quiz-status-no",
  templateUrl: "./quiz-status-no.component.html",
  styleUrls: ["./quiz-status-no.component.css"]
})
export class QuizStatusNoComponent implements OnInit {
  userId;
  id;
  endURL;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit() {
    this.http
      .get(
        "http://localhost:8080/quizmania/updateStatusNo/" +
          this.route.params["_value"]["id"]
      )
      .subscribe(data => {});
  }

  goBack() {
    console.log("here...");
    this.endURL = "/admin-dashboard/" + this.userId + "";
    this.router.navigate([this.endURL]);
  }
}
