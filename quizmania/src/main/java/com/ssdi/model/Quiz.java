package com.ssdi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer quizID;
	// title for quiz, 100 characters limit
	private String title;
	
	private int timeLimit;
	// subject for quiz, 50-chars limit 
	private String category;
    private String status;
    @OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private Collection<Question> questions;
	@ManyToOne 
	private User author;
	private String comment;
    
    public Quiz() {
		super();
		questions = new ArrayList<Question>();
	}
    
	public Quiz(String title, int timeLimit, String category, String status) {
		super();
		this.title = title;
		this.timeLimit = timeLimit;
		this.status=status;
		this.category = category;
		
	}
	
	public Integer getQuizID() {
		return quizID;
	}
	
	public void setQuizID(Integer quizID) {
		this.quizID = quizID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getTimeLimit() {
		return timeLimit;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return the questions
	 */
	public Collection<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param user the author to set
	 */
	public void setAuthor(User user) {
		this.author = user;
	}
	
	//public void addQuestion(Question q) {
		//questions.add(q);
	//}
	
	//public ArrayList<Question> getQuestions(){
		//return questions;
	//}
	
	
	@Override 
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} 
		if (!(o instanceof Quiz)) {
			return false; 
		}
		
		Quiz q = (Quiz) o;
		if (q.getTitle().equals(title) && q.getTimeLimit() == timeLimit && q.getStatus().equals(status) && q.getCategory().equals(category)) {
			return true;
		} else { 
			return false;
		}
		
	}

	public String toString() {
		return title + " (" + category + ")";
	}
	
	/**
	 * @return the adminComment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param adminComment the adminComment to set
	 */
	public void setComment(String adminComment) {
		this.comment = adminComment;
	}

}
