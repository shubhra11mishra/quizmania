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
	private String correct_answer;
	private int points;
	private int number;
	/** type is 1 for multiple-choice questions, 
	 *  type is 2 for essay questions, ...
	 */
	private int type; 
	/**
	 * choices for multiple-choice questions 
	 */
	private String choicea, choiceb, choicec, choiced;
    @ManyToOne
	private Quiz quizID;

    public Question() {
		super();
	}
	
    public Question(Integer questionID, String body, String correct_answer, int points, Quiz quizID) {
		super();
		this.questionID = questionID;
		this.body = body;
		this.correct_answer = correct_answer;
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
	 * @return the correct_answer
	 */
	public String getCorrect_answer() {
		return correct_answer;
	}

	/**
	 * @param correct_answer the correct_answer to set
	 */
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	/**
	 * @return the choicea
	 */
	public String getChoicea() {
		return choicea;
	}

	/**
	 * @param choicea the choicea to set
	 */
	public void setChoicea(String choicea) {
		this.choicea = choicea;
	}

	/**
	 * @return the choiceb
	 */
	public String getChoiceb() {
		return choiceb;
	}

	/**
	 * @param choiceb the choiceb to set
	 */
	public void setChoiceb(String choiceb) {
		this.choiceb = choiceb;
	}

	/**
	 * @return the choicec
	 */
	public String getChoicec() {
		return choicec;
	}

	/**
	 * @param choicec the choicec to set
	 */
	public void setChoicec(String choicec) {
		this.choicec = choicec;
	}

	/**
	 * @return the choiced
	 */
	public String getChoiced() {
		return choiced;
	}

	/**
	 * @param choiced the choiced to set
	 */
	public void setChoiced(String choiced) {
		this.choiced = choiced;
	}
	
	
}
