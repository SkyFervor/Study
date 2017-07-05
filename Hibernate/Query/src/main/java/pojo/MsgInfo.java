package pojo;

public class MsgInfo {
	private int id;
	private String msgName;
	private String topicName;
	private String categoryName;

	public MsgInfo(int id, String msgName, String topicName, String categoryName) {
		super();
		this.id = id;
		this.msgName = msgName;
		this.topicName = topicName;
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsgName() {
		return msgName;
	}

	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
