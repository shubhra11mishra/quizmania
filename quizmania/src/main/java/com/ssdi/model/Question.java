package com.ssdi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer questionID;
	private String body;
	private String correctAnswer;
	private int points;
	private int number;
	/** type is 1 for multiple-choice questions, 
	 *  type is 2 for essay questions, ...
	 */
	private int type; 
	/**
	 * choices for multiple-choice questions 
	 */
	private String choiceA, choiceB, choiceC, choiceD;
    @ManyToOne
	private Quiz quizID;

    public Question() {
		super();
	}
	
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
	
	public String toString() {
		return this.body + " (" + points + ")";
	}
	
	public Quiz getQuizID() {
		return quizID;
	}
	public void setQuizID(Quiz quizID) {
		this.quizID = quizID;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the choiceA
	 */
	public String getChoiceA() {
		return choiceA;
	}

	/**
	 * @param choiceA the choiceA to set
	 */
	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}

	/**
	 * @return the choiceB
	 */
	public String getChoiceB() {
		return choiceB;
	}

	/**
	 * @param choiceB the choiceB to set
	 */
	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}

	/**
	 * @return the choiceC
	 */
	public String getChoiceC() {
		return choiceC;
	}

	/**
	 * @param choiceC the choiceC to set
	 */
	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}

	/**
	 * @return the choiceD
	 */
	public String getChoiceD() {
		return choiceD;
	}

	/**
	 * @param choiceD the choiceD to set
	 */
	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}
	
	
}
