import { Component, OnInit , Injectable } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { QuizService } from '../shared';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-viewquiz',
  templateUrl: './viewquiz.component.html',
  styleUrls: ['./viewquiz.component.css']
})
@Injectable()
export class ViewQuizComponent implements OnInit {
  userId;
  quizId;
  endURL = '';

  // quizzes: Array<any>;
  questions;
  constructor(private route: ActivatedRoute, private quizService: QuizService, private http: HttpClient, private router: Router) {}

  ngOnInit() {
    console.log('in view quiz ts!..');
    this.route.params.subscribe((params: Params) => {
      this.userId = params['userid'];
      this.quizId = params['id'];
      console.log(this.userId);
      this.quizService.getAllQuestions(this.userId, this.quizId).subscribe(
        data => {
          console.log(data);
          this.questions = data;
          console.log(
            'view quizzes ts, got quizzes for user: ' + this.userId + '!'
          );
        },
        error => console.log(error)
      );
    });
  }

  goBack() {
    console.log('here...');
    this.endURL = '/admin-dashboard/' + this.userId + '';
    this.router.navigate([this.endURL]);
  }

  approve() {
    this.endURL = '/quiz-status/' + this.quizId + '';
    this.router.navigate([this.endURL]);
    console.log('approve...quiz ' + this.quizId + ' for user ' + this.userId);
  }

  reject() {
    this.endURL = '/quiz-status-no/' + this.quizId + '';
    this.router.navigate([this.endURL]);
    console.log('reject...quiz ' + this.quizId + ' for user ' + this.userId);
  }
}
