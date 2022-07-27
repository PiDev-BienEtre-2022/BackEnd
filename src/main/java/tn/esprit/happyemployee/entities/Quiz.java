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
@Table(name = "quiz")
public class Quiz{
	@Id
	@Column(name = "id_quiz", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuiz;

	@JsonIgnore
	@Nullable
	@ManyToOne
	private User createdBy;

	@Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
	@NotNull(message = "Please provide a name")
	private String name;

	public CategoriesQuizEtQuestion getCategoriesQuizEtQuestion() {
		return categoriesQuizEtQuestion;
	}

	public void setCategoriesQuizEtQuestion(CategoriesQuizEtQuestion categoriesQuizEtQuestion) {
		this.categoriesQuizEtQuestion = categoriesQuizEtQuestion;
	}


	@Enumerated(EnumType.STRING)
	@NotNull
	private CategoriesQuizEtQuestion categoriesQuizEtQuestion;

	@Size(max = 500, message = "The description can't be longer than 500 characters.")
	@NotNull(message = "Please, provide a description")
	private String description;

	public void setCreatedDate(@Nullable Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getPublished() {
		return isPublished;
	}

	public void setPublished(Boolean published) {
		isPublished = published;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
	private List<Question> questions;

	@JsonIgnore
	@Nullable
	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_DATETIME", updatable = false)
	private Date createdDate;

	private Boolean isPublished = false;

	public Long getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(Long idQuiz) {
		this.idQuiz = idQuiz;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> exercises) {
		this.questions = exercises;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public User getUser() {
		return getCreatedBy();
	}

	public Boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idQuiz == null) ? 0 : idQuiz.hashCode());
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
		Quiz other = (Quiz) obj;
		if (idQuiz == null) {
			if (other.idQuiz != null)
				return false;
		} else if (!idQuiz.equals(other.idQuiz))
			return false;
		return true;
	}
}
