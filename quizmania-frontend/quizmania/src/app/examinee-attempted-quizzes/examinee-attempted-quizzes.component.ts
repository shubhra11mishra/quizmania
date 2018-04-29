import { Injectable, Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ExamineeAttemptedQuizzesService } from './examinee-attempted-quizzes.service';

@Component({
  selector: 'app-examinee-attempted-quizzes',
  templateUrl: './examinee-attempted-quizzes.component.html',
  styleUrls: ['./examinee-attempted-quizzes.component.css']
})
export class ExamineeAttemptedQuizzesComponent implements OnInit {
  quizzes: Array<any>;
  userId = '';
  endURL = '';

  constructor(
    private examineeAttemptedQuizzesService: ExamineeAttemptedQuizzesService,
    private httpClient: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.userId = params['userid'];
      console.log(this.userId);
      this.examineeAttemptedQuizzesService.getAllAttemptedQuizzes(this.userId).subscribe(
        data => {
          console.log(data);
          this.quizzes = data;
        },
        error => console.log(error)
      );
    });
  }

  goBack() {
    this.endURL = '/examinee-dashboard/' + this.userId + '';
    this.router.navigate([this.endURL]);
  }

}
