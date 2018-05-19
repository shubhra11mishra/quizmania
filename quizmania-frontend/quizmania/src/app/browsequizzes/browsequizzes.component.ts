import { Injectable, Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { QuizService } from "../shared";
import { BrowseQuizzesService } from "./browsequizzes.service";

@Component({
  selector: 'app-take-quiz',
  templateUrl: './browsequizzes.component.html',
  styleUrls: ['./browsequizzes.component.css']
})
export class BrowseQuizzesComponent implements OnInit {
  quizzes: any[];
  userId = '';
  endURL = '';
  successful;

  constructor(
    private quizService: QuizService,
    private browseQuizzesService: BrowseQuizzesService,
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
    console.log('Going to attempt quiz:' + quizID);
    
    this.browseQuizzesService.takeQuiz(this.userId, quizID)
    .subscribe(
    	//console.log("okay, browse quiz service done");
      (response) => {this.successful = true},
      (error) => console.log(error)
    );
    /**
    this.endURL = 'quizmania/' + this.userId + '/viewquiz/' + quizID;
    this.router.navigate([this.endURL]);
    */
  }

  goBack() {
    this.endURL = '/examinee-dashboard/' + this.userId + '';
    this.router.navigate([this.endURL]);
  }

}
