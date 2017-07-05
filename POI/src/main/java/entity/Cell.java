package entity;

public class Cell {
	private String content;

	public Cell() {
		this("");
	}

	public Cell(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return content;
	}

}
