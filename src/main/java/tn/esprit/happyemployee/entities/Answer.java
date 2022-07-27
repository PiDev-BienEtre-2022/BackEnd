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

	@Size(min = 1, max = 50, message = "The answer should be less than 50 characters")
	@NotNull(message = "No answer text provided.")
	private String text;

	@ManyToOne
	private Question question;

	@JsonIgnore
	@Nullable
	@Column(name = "a_order")
	private Integer order;

	@JsonIgnore
	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_DATETIME",insertable = false,  updatable = false)
	private Date createdDate;

	public Date getCreatedDate() {
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

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Nullable
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(@Nullable User createdBy) {
		this.createdBy = createdBy;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	@JsonIgnore
	@Nullable
	@ManyToOne
	private User createdBy;
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
