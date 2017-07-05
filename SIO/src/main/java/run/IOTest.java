package run;

import java.io.IOException;
import java.util.List;

import core.FileInput;
import core.FileOutput;

public class IOTest {
	public static void main(String[] args) throws IOException {
		String inputPath = "D://1.txt";
		String outputPath = "D://2.txt";

		FileInput fi = new FileInput(inputPath);
		List<List<String>> list = fi.read("=");
		fi.close();

		FileOutput fo = new FileOutput(outputPath);
		fo.write(list, " : ");
		fo.close();
	}
}
