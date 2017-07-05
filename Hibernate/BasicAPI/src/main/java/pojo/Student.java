package pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
// 利用生成器来实现自动设置主键
@TableGenerator(name = "studentGenerator", table = "generator", pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "Student_id", initialValue = 1, allocationSize = 1)
public class Student {
	private int id;
	private String name;
	private Date birthDay;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "studentGenerator")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

}
