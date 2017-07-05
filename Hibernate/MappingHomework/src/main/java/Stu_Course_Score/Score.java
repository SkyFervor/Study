package Stu_Course_Score;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score {
	private int id;
	private int score;
	private Student student;
	private Course course;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	public Course getCourse() {
		return course;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
