import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

@Component({
  selector: "app-quiz-status",
  templateUrl: "./quiz-status.component.html",
  styleUrls: ["./quiz-status.component.css"]
})
export class QuizStatusComponent implements OnInit {
  userId;
  id;
  endURL = "";

  constructor(private route: ActivatedRoute, private http: HttpClient, private router: Router) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.userId = params["userid"];
    });

    this.http
      .get(
        "http://localhost:8080/quizmania/updateStatusYes/" +
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
