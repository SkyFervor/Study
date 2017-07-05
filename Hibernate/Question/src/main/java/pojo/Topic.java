package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "topic.selectCertainTopic",
		query = "from Topic t where t.id = :id") })
@NamedNativeQueries({ @NamedNativeQuery(name = "topic.select2_5Topic",
		query = "select * from topic limit 2, 5") })
public class Topic {
	private int id;
	private String name;
	private Date createDate;
	private Category category;
	private List<Message> messages = new ArrayList<Message>();

	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	@Temporal(TemporalType.DATE)
	public Date getCreateDate() {
		return createDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@OneToMany(mappedBy = "topic")
	public List<Message> getMessages() {
		return messages;
	}

	public String getName() {
		return name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setName(String name) {
		this.name = name;
	}

}
