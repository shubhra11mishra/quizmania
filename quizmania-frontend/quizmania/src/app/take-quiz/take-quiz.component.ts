import { Injectable, Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { QuizService } from "../shared";
import { TakeQuizService } from "./take-quiz.service";

@Component({
  selector: 'app-take-quiz',
  templateUrl: './take-quiz.component.html',
  styleUrls: ['./take-quiz.component.css']
})
export class TakeQuizComponent implements OnInit {
  quizzes: any[];
  userId = '';
  endURL = '';
  successful;

  constructor(
    private quizService: QuizService,
    private takeQuizService: TakeQuizService,
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

  takeQuiz(quizID){
    console.log('Going to attempt quiz:'+quizID);
    this.takeQuizService.takeQuiz(this.userId, quizID)
    .subscribe(
      (response) => {this.successful = true},
      (error) => console.log(error)
    );
  }

  goBack() {
    this.endURL = '/examinee-dashboard/' + this.userId + '';
    this.router.navigate([this.endURL]);
  }

}
