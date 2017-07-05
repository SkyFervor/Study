package run;

import java.io.IOException;

import core.FileOutput;
import core.InputResolver;
import entity.Sheet;
import excel.ExcelResolver;

public class ReadExcel2 {
	public static void main(String[] args) {
		String inputPath = "D://2.xlsx";
		Sheet sheet = new Sheet();
		try (InputResolver<String> resolver = new ExcelResolver<>(inputPath);) {
			sheet = resolver.read(0, 1, 262);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		String outputPath = "D://1.sql";
		try (FileOutput fileOutput = new FileOutput(outputPath)) {
			fileOutput.write(sheet, "', '");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
