package tn.esprit.happyemployee.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import tn.esprit.happyemployee.domain.enums.CategoriesQuizEtQuestion;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question")
public class Question {
	@Id
	@Column(name = "id_question", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuestion;

	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public CategoriesQuizEtQuestion getCategoriesQuizEtQuestion() {
		return categoriesQuizEtQuestion;
	}

	public void setCategorieQuestion(CategoriesQuizEtQuestion categoriesQuizEtQuestion) {
		this.categoriesQuizEtQuestion = categoriesQuizEtQuestion;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getValid() {
		return isValid;
	}

	public void setValid(Boolean valid) {
		isValid = valid;
	}

	@Enumerated(EnumType.STRING)
	@NotNull
	private CategoriesQuizEtQuestion categoriesQuizEtQuestion;

	@Size(min = 2, max = 150, message = "The question should be between 2 and 150 characters")
	@NotNull(message = "Question text not provided")
	private String text;

	@JsonIgnore
	@ManyToOne
	private Quiz quiz;

	@Nullable
	@JsonIgnore
	@Column(name = "q_order")
	private Integer order;

	@JsonIgnore
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Answer> answers;

	@JsonIgnore
	@OneToOne
	private Answer correctAnswer;

	@JsonIgnore
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date createdDate;

	private Boolean isValid = false;

	public Date getCreatedDate() {
		return createdDate;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@JsonIgnore
	@Nullable
	public User getUser() {
		return quiz.getUser();
	}
	@JsonIgnore
	@Nullable
	@ManyToOne
	private User createdBy;

	public void setCategoriesQuizEtQuestion(CategoriesQuizEtQuestion categoriesQuizEtQuestion) {
		this.categoriesQuizEtQuestion = categoriesQuizEtQuestion;
	}

	@Nullable
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(@Nullable User createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public Answer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idQuestion == null) ? 0 : idQuestion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (idQuestion == null) {
			if (other.idQuestion != null)
				return false;
		} else if (!idQuestion.equals(other.idQuestion))
			return false;
		return true;
	}
}
