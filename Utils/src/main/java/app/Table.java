package app;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Table {
	private String name;
	private Map<String, String> map;
	private List<String> keyList;

	public Table(String name, Map<String, String> map, String... keys) {
		this.name = name;
		this.map = map;
		keyList = new LinkedList<>();
		keyList.addAll(Arrays.asList(keys));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<String> getKeyList() {
		return keyList;
	}

	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}

}
