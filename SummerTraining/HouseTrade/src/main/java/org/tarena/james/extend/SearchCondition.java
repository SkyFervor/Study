package org.tarena.james.extend;

public class SearchCondition {
	private String scname;
	private String scid;
	private String scsql;
	@Override
	public String toString() {
		return "SearchCondition [scid=" + scid + ", scname=" + scname
				+ ", scsql=" + scsql + "]";
	}
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	public String getScid() {
		return scid;
	}
	public void setScid(String scid) {
		this.scid = scid;
	}
	public String getScsql() {
		return scsql;
	}
	public void setScsql(String scsql) {
		this.scsql = scsql;
	}
}
