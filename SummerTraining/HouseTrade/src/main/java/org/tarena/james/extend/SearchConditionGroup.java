package org.tarena.james.extend;

import java.util.ArrayList;
import java.util.List;

public class SearchConditionGroup {
	@Override
	public String toString() {
		return "SearchConditionGroup [scgname=" + scgname
				+ ", searchConditions=" + searchConditions + "]";
	}
	private String scgname;
	private List<SearchCondition> searchConditions = 
		new ArrayList<SearchCondition>();
	public List<SearchCondition> getSearchConditions() {
		return searchConditions;
	}
	public void setSearchConditions(List<SearchCondition> searchConditions) {
		this.searchConditions = searchConditions;
	}
	public String getScgname() {
		return scgname;
	}
	public void setScgname(String scgname) {
		this.scgname = scgname;
	}
}
