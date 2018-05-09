import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { QuizService } from '../shared';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-viewquizcategories',
  templateUrl: './viewquizcategories.component.html',
  styleUrls: ['./viewquizcategories.component.css']
})
export class ViewquizcategoriesComponent implements OnInit {

  categories;
  endURL='';
  userId;
  constructor(private route: ActivatedRoute, private quizService: QuizService, private http: HttpClient, private router: Router) {}

  ngOnInit() {
    console.log('in view quizcategories ts!..');
    this.route.params.subscribe((params: Params) => {
      this.userId=params['userid']
      this.quizService.getQuizCategories().subscribe(
        data => {
          console.log(data);
          this.categories = data;
          console.log(
            'got categories from Quizservice'
          );
        },
        error => console.log(error)
      );
    });
  }

  viewQuiz(post) {
    this.endURL = '/quizByCategory/'+this.userId+'/'+post ;
    this.router.navigate([this.endURL]);
    // console.log('approve...quiz ' + this.quizId + ' for user ' + this.userId);
  }

}
