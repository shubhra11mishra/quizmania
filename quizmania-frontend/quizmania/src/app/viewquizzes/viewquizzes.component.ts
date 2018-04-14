import { Component, OnInit } from '@angular/core';
import { QuizService } from '../shared';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-viewquizzes',
  templateUrl: './viewquizzes.component.html',
  styleUrls: ['./viewquizzes.component.css']
})
export class ViewQuizzesComponent implements OnInit {
	
	quizzes: Array<any>;
	
 	constructor(private quizService: QuizService) { }

 	ngOnInit() {
    	this.quizService.getAll().subscribe(
    		data => {
        		console.log(data);
        		this.quizzes = data;
        		console.log(this.quizzes)
      		},
      		error => console.log(error)
    	)
  	}
}
