package run;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import core.FileOutput;
import core.InputResolver;
import entity.Sheet;
import excel.ExcelResolver;

public class ReadExcel1 {
	public static void main(String[] args) {
		String inputPath = "D://自主上房翻译_Korean.xlsx";
		List<Integer> columns = new LinkedList<>();
		columns.add(0);
		columns.add(4);
		Sheet sheet = new Sheet();
		try (InputResolver<String> resolver = new ExcelResolver<>(inputPath);) {
			sheet = resolver.read(0, 1, columns);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String outputPath = "D://2.txt";
		try (FileOutput fileOutput = new FileOutput(outputPath)) {
			fileOutput.write(sheet, "=");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
