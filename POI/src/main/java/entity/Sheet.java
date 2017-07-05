package entity;

import java.util.LinkedList;
import java.util.List;

import core.OutputEntity;

public class Sheet implements OutputEntity<Row> {
	private List<Row> rows;

	public Sheet() {
		rows = new LinkedList<>();
	}

	public void addRow(Row row) {
		rows.add(row);
	}

	@Override
	public List<Row> toList() {
		return getRows();
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

}
