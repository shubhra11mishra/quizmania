import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-quiz-status',
  templateUrl: './quiz-status.component.html',
  styleUrls: ['./quiz-status.component.css']
})
export class QuizStatusComponent implements OnInit {

  id;
  
  
  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    
    this.http.get('http://localhost:8080/quizmania/updateStatusYes/'+ this.route.params['_value']['id'] ).subscribe(data => {
      
      
    });
  }

  
  
  }
