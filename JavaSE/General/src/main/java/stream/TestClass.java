package stream;

/**
 * Created by skyfervor
 * 2017/03/29 20:55
 */
public class TestClass {
	private String name;
	private Integer value;

	private String author;

	public TestClass(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public TestClass(String name, int value, String author) {
		this(name, value);
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "TestClass{" +
				"name='" + name + '\'' +
				", value=" + value +
				", author='" + author + '\'' +
				'}';
	}
}
