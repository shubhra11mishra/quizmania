import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-view-question',
  templateUrl: './view-question.component.html',
  styleUrls: ['./view-question.component.css']
})
export class ViewQuestionComponent implements OnInit {
  id;
  // quizzes: Array<any>;
  quizzes;
  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    

    if(this.route.params){
     
      this.http.get('http://localhost:8080/quizmania/examiner/viewQuestion/'+ this.route.params['_value']['id'] ).subscribe(data => {
      
        this.quizzes = data;
        
      });
    }

  }
  }


