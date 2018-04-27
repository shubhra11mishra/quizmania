import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { QuizService } from '../shared';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-viewquiz-bycategory',
  templateUrl: './viewquiz-bycategory.component.html',
  styleUrls: ['./viewquiz-bycategory.component.css']
})
export class ViewquizBycategoryComponent implements OnInit {

  quizzess;
  quizId;
  constructor(private route: ActivatedRoute, private quizService: QuizService, private http: HttpClient, private router: Router) {}

  ngOnInit() {
    console.log('in view quizBycategory ts!..');
    this.route.params.subscribe((params: Params) => {
      this.quizId = params['id'];
      this.quizService.getQuizByCategory(this.quizId).subscribe(
        data => {
          console.log(data);
          this.quizzess = data;
          console.log(
            'got quizzess from Quizservice'
          );
        },
        error => console.log(error)
      );
    });
  }
}
