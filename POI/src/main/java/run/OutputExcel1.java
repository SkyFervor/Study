package run;

import entity.Cell;
import entity.Row;
import entity.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

/**
 * Created by skyfervor
 * 2016/11/24 16:22
 */
public class OutputExcel1 {
	public static void main(String[] args) {
		String inputPath = "D:\\2.txt";
		Sheet sheet = new Sheet();
		try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty() || line.equals("\uFEFF"))
					continue;

				Row row = new Row();
				Cell number = new Cell();
				Cell active = new Cell();
				Cell name = new Cell();
				row.addCell(number);
				row.addCell(active);
				row.addCell(name);

				setCellContent(row.getCells(), line);
				line = reader.readLine();
				if (line == null || line.isEmpty() || line.equals("\uFEFF"))
					line = reader.readLine();
				setCellContent(row.getCells(), line);
				line = reader.readLine();
				if (line == null || line.isEmpty() || line.equals("\uFEFF"))
					line = reader.readLine();
				setCellContent(row.getCells(), line);

				sheet.addRow(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		XSSFSheet xssfSheet = xssfWorkbook.createSheet();
		List<Row> rows = sheet.getRows();
		for (int i = 0; i < rows.size(); i++) {
			Row row = rows.get(i);
			XSSFRow xssfRow = xssfSheet.createRow(i);
			List<Cell> cells = row.getCells();
			for (int j = 0; j < cells.size(); j++) {
				XSSFCell cell = xssfRow.createCell(j);
				cell.setCellValue(cells.get(j).getContent());
			}
		}
		String outputPath = "D:\\3.xlsx";
		try (OutputStream out = new FileOutputStream(outputPath)) {
			xssfWorkbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void setCellContent(List<Cell> cells, String line) {
		if (line.startsWith("\"HN")) {
			cells.get(0).setContent(line.substring(1, line.length() - 1));
		} else if (line.startsWith("\"isActive\"")) {
			if (line.endsWith("true"))
				cells.get(1).setContent("是");
			else if (line.endsWith("false"))
				cells.get(1).setContent("否");
			else
				cells.get(1).setContent("unknowActive");
		} else {
			System.out.println(line);
			cells.get(2).setContent(line.substring(1, line.length() - 1));
		}
	}
}
