package excel;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import core.AbstractResolver;
import entity.Cell;
import entity.Row;
import entity.Sheet;

public class ExcelResolver<T> extends AbstractResolver<T> {

	public ExcelResolver(File file) throws IOException {
		super(file);
	}

	public ExcelResolver(String filePath) throws IOException {
		super(filePath);
	}

	@Override
	public Sheet read(int sheetNum, int rowStart, int rowEnd, List<Integer> columns) {
		if (sheetNum < 0 || sheetNum >= xssfWorkbook.getNumberOfSheets())
			return new Sheet(); // TODO

		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetNum);
		if (xssfSheet == null)
			return new Sheet(); // TODO
		if (rowStart < 0 || rowEnd > xssfSheet.getLastRowNum() || rowStart > rowEnd)
			return new Sheet(); // TODO

		Sheet sheet = new Sheet();
		for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
			XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			if (xssfRow == null) {
				sheet.addRow(new Row());
				continue;
			}

			Row row = new Row();
			XSSFCell xssfCell = null;
			if (columns == null || columns.isEmpty()) {
				for (int cellNum = xssfRow.getFirstCellNum(); cellNum < xssfRow.getLastCellNum(); cellNum++) {
					xssfCell = xssfRow.getCell(cellNum);
					if (xssfCell == null) {
						row.addCell(new Cell());
						continue;
					}
					row.addCell(new Cell(getValue(xssfCell)));
				}
			} else {
				for (Integer cellNum : columns) {
					if (cellNum == null || cellNum < xssfRow.getFirstCellNum() || cellNum >= xssfRow.getLastCellNum())
						continue;
					xssfCell = xssfRow.getCell(cellNum);
					if (xssfCell == null) {
						row.addCell(new Cell());
						continue;
					}
					row.addCell(new Cell(getValue(xssfCell)));
				}
			}
			sheet.addRow(row);
		}
		return sheet;
	}

	@Override
	public Sheet read(int sheetNum, int rowStart, int rowEnd) {
		return read(sheetNum, rowStart, rowEnd, null);
	}

	@Override
	public Sheet read(int sheetNum, int rowStart, List<Integer> columns) {
		if (sheetNum < 0 || sheetNum >= xssfWorkbook.getNumberOfSheets())
			return new Sheet();
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetNum);
		return read(sheetNum, rowStart, xssfSheet.getLastRowNum(), columns);
	}

	@Override
	public Sheet read(int sheetNum, List<Integer> columns) {
		if (sheetNum < 0 || sheetNum >= xssfWorkbook.getNumberOfSheets())
			return new Sheet();
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetNum);
		return read(sheetNum, xssfSheet.getFirstRowNum(), xssfSheet.getLastRowNum(), columns);
	}

	@Override
	public Sheet read(int sheetNum) {
		return read(sheetNum, null);
	}

	@Override
	public List<Sheet> read() {
		List<Sheet> sheetList = new LinkedList<>();
		for (int sheetNum = 0; sheetNum < xssfWorkbook.getNumberOfSheets(); sheetNum++)
			sheetList.add(read(sheetNum));
		return sheetList;
	}

	@Override
	public boolean write(Sheet sheet) {
		sheet.toList();
		return false;
	}

}
