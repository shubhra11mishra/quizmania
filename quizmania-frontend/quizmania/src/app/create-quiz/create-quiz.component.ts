import { Component, OnInit } from '@angular/core';
import { Quiz } from '../quiz';
import { CreateQuizService } from './createquiz.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.css']
})
export class CreateQuizComponent implements OnInit {

	successful= false;
	quiz:Quiz = new Quiz();
	
	constructor(private createQuizService: CreateQuizService) { }

  	ngOnInit() {
  	}

	createQuiz(form: NgForm){
    	this.quiz.title = form.value.title;
    	this.quiz.timeLimit = form.value.timeLimit;
    	this.quiz.category = form.value.timeLimit;
    	this.quiz.status = form.value.status;
    	form.reset();
    
    	this.createQuizService.createQuiz(this.quiz)
    		.subscribe(
        	(response) => {this.successful = true},
        	(error) => console.log(error)
      	);
  	}	
  
}
