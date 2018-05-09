package com.ssdi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Response {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer responseID;
	
	@ManyToOne
	private Question questionID;
	@ManyToOne
	private Attempt attemptID;
	private String resp; 
	private String isCorrect;
	
	public Response() {
		super();
	}
	
	/**
	 * @param questionNum
	 * @param attemptID
	 * @param isCorrect
	 */
	public Response(Question question, Attempt attemptID, String response, String isCorrect) {
		this.questionID = question;
		this.attemptID = attemptID;
		this.isCorrect = isCorrect;
		this.resp = response;
	}

	/**
	 * @return the responseID
	 */
	public Integer getResponseID() {
		return responseID;
	}

	/**
	 * @param responseID the responseID to set
	 */
	public void setResponseID(Integer responseID) {
		this.responseID = responseID;
	}

	/**
	 * @return the questionID
	 */
	public Question getQuestionID() {
		return questionID;
	}

	/**
	 * @param questionID the questionID to set
	 */
	public void setQuestionID(Question questionID) {
		this.questionID = questionID;
	}

	/**
	 * @return the attemptID
	 */
	public Attempt getAttemptID() {
		return attemptID;
	}

	/**
	 * @param attemptID the attemptID to set
	 */
	public void setAttemptID(Attempt attemptID) {
		this.attemptID = attemptID;
	}

	/**
	 * @return the isCorrect
	 */
	public String getIsCorrect() {
		return isCorrect;
	}

	/**
	 * @param isCorrect the isCorrect to set
	 */
	public void setIsCorrect(String isCorrect) {
		this.isCorrect = isCorrect;
	} 
	/**
	 * @return the resp
	 */
	public String getResp() {
		return resp;
	}

	/**
	 * @param resp the resp to set
	 */
	public void setResp(String resp) {
		this.resp = resp;
	}

}
