import { Injectable, Component, OnInit } from "@angular/core";
import { QuizService } from "../shared";
import { HttpClient } from "@angular/common/http";
import { ActivatedRoute, Params, Router } from "@angular/router";

@Component({
  selector: "app-viewquizzes",
  templateUrl: "./viewquizzes.component.html",
  styleUrls: ["./viewquizzes.component.css"],
  providers: [QuizService]
})
@Injectable()
export class ViewQuizzesComponent implements OnInit {
  quizzes: Array<any>;
  userId = "";
  endURL = "";

  constructor(
    private quizService: QuizService,
    private httpClient: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.userId = params["userid"];
      console.log(this.userId);
      // get the type of user for appropriate header
      // To-Do!!!
      this.quizService.getAll(this.userId).subscribe(
        data => {
          console.log(data);
          this.quizzes = data;
          console.log(
            "view quizzes ts, got quizzes for user: " + this.userId + "!"
          );
          // console.log(this.quizzes)
        },
        error => console.log(error)
      );
    });
  }

  goBack() {
    console.log("here...");
    this.endURL = "/examiner-dashboard/" + this.userId + "";
    this.router.navigate([this.endURL]);
  }

  /**
  addQuestions(quizid) {
    console.log('yay!' + quizid);
    this.endURL = '/quizmania/' + this.userId + '/editquiz/' + quizid + '/addquestions';
    this.router.navigate([this.endURL]);
  }
*/
  review(quizid) {
    console.log("reviewing quiz " + quizid);
  }

  publish(quizid) {
    console.log("publish quiz " + quizid);
  }
}
