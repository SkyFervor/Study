package entity;

import java.util.LinkedList;
import java.util.List;

import core.OutputEntity;

public class Row implements OutputEntity<String> {
	private List<Cell> cells;

	public Row() {
		this.cells = new LinkedList<>();
	}

	public void addCell(Cell cell) {
		cells.add(cell);
	}

	@Override
	public List<String> toList() {
		List<String> list = new LinkedList<>();
		for (Cell cell : cells)
			list.add(cell.toString());
		return list;
	}

	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

}
