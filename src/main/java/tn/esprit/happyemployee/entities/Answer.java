package tn.esprit.happyemployee.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.happyemployee.domain.enums.CategoriesQuizEtQuestion;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answer")
public class Answer{
	@Id
	@Column(name = "id_answer", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnswer;

	public Long getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(Long idQuestion) {
		this.idAnswer = idQuestion;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	@Size(min = 1, max = 50, message = "The answer should be less than 50 characters")
	@NotNull(message = "No answer text provided.")
	private String text;

	@ManyToOne
	@JsonIgnore
	private Question question;

	@Column(name = "a_order")
	private Integer order;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Calendar createdDate;

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@JsonIgnore
	public User getUser() {
		return question.getUser();
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Answer [text=" + text + ", question=" + question + ", order=" + order + ", createdDate=" + createdDate
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAnswer == null) ? 0 : idAnswer.hashCode());
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
		Answer other = (Answer) obj;
		if (idAnswer == null) {
			if (other.idAnswer != null)
				return false;
		} else if (!idAnswer.equals(other.idAnswer))
			return false;
		return true;
	}
}
