package pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
// @BatchSize(size = 5)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "sampleCache1")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;

		Category c = (Category) o;
		if (c.id != this.id)
			return false;
		if (c.name != this.name)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + id;
		result = 31 * result + name.hashCode();
		return result;
	}
}
