import { Component, OnInit } from '@angular/core';
import { QuizService } from '../shared';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-pending-quiz',
  templateUrl: './pending-quiz.component.html',
  styleUrls: ['./pending-quiz.component.css'],
  providers: [QuizService]
  
  
})
export class PendingQuizComponent implements OnInit {

  quizzes: Array<any>;

  constructor(private quizService: QuizService) { }

  ngOnInit() {
  	// To-Do!!! Pass in admin user id 
    this.quizService.getAll(0).subscribe(
      data => {
        console.log(data);
        this.quizzes = data;
        console.log(this.quizzes)
      }, 
      error => console.log(error)
    )
  }
}