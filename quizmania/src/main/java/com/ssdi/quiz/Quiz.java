package com.ssdi.quiz;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import com.ssdi.question.Question;
import com.ssdi.user.examiner.Examiner;

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
    @ManyToOne
    private Examiner examiner; 
    /**
	 * @return the examiner
	 */
	public Examiner getExaminer() {
		return examiner;
	}

	/**
	 * @param examiner the examiner to set
	 */
	public void setExaminer(Examiner examiner) {
		this.examiner = examiner;
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

	@OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private Collection<Question> questions;
	
    public Quiz() {
		super();
		questions = new ArrayList<Question>();
	}
    
	public Quiz(String title, int timeLimit, String status) {
		super();
		this.title = title;
		this.timeLimit = timeLimit;
		this.status=status;
		
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
	
	public void addQuestion(Question q) {
		questions.add(q);
	}
	
}
