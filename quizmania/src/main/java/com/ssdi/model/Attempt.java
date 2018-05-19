package com.ssdi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Attempt {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer attemptID;
	
	private int count;
	@ManyToOne
	private Quiz quizID;
	@ManyToOne
	private User userID;
	private Date attemptDate;
	private int userScore, maxScore;
	private double percent;
	
	/**
	 * @param quizID
	 * @param userID
	 */
	public Attempt(Quiz quizID, User userID, int count) {
		super();
		this.quizID = quizID;
		this.userID = userID;
		this.count = count;
		this.attemptDate = new Date(System.currentTimeMillis());
	}

	/**
	 * @return the attemptID
	 */
	public Integer getAttemptID() {
		return attemptID;
	}

	/**
	 * @param attemptID the attemptID to set
	 */
	public void setAttemptID(Integer attemptID) {
		this.attemptID = attemptID;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the quizID
	 */
	public Quiz getQuizID() {
		return quizID;
	}

	/**
	 * @param quizID the quizID to set
	 */
	public void setQuizID(Quiz quizID) {
		this.quizID = quizID;
	}

	/**
	 * @return the userID
	 */
	public User getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(User userID) {
		this.userID = userID;
	}

	/**
	 * @return the attemptDate
	 */
	public Date getAttemptDate() {
		return attemptDate;
	}

	/**
	 * @param attemptDate the attemptDate to set
	 */
	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}

	/**
	 * @return the userScore
	 */
	public int getUserScore() {
		return userScore;
	}

	/**
	 * @param userScore the userScore to set
	 */
	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	/**
	 * @return the maxScore
	 */
	public int getMaxScore() {
		return maxScore;
	}

	/**
	 * @param maxScore the maxScore to set
	 */
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	/**
	 * @return the percent
	 */
	public double getPercent() {
		return percent;
	}
	
	/**
	 * @param maxScore the maxScore to set
	 */
	public void setPercent(double percent) {
		this.percent = percent;
	}
}
