package com.ssdi.question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssdi.quiz.Quiz;

@Entity
public class Question {
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer questionID;
	private String body;
	private String correctAnswer;
	private int points;
    @ManyToOne
	private Quiz quizID;

	public Question(Integer questionID, String body, String correctAnswer, int points, Quiz quizID) {
		super();
		this.questionID = questionID;
		this.body = body;
		this.correctAnswer = correctAnswer;
		this.points = points;
		this.quizID = quizID;
	}
	
	@JsonIgnore
	public Integer getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	public Quiz getQuizID() {
		return quizID;
	}
	public void setQuizID(Quiz quizID) {
		this.quizID = quizID;
	}
	
	
}
