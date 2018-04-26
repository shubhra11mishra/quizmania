import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-quiz-status-no',
  templateUrl: './quiz-status-no.component.html',
  styleUrls: ['./quiz-status-no.component.css']
})
export class QuizStatusNoComponent implements OnInit {

  id;
  
  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8080/quizmania/examiner/updateStatusNo/'+ this.route.params['_value']['id'] ).subscribe(data => {
      
      
    });
  }
}