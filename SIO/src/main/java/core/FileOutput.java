package core;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileOutput implements Closeable {
	BufferedWriter out;
	static final String LINE_END = "\r\n";

	public FileOutput(File file) throws IOException {
		if (file != null && file.exists())
			file.delete();
		this.out = new BufferedWriter(new FileWriter(file));
	}

	public FileOutput(String filePath) throws IOException {
		this(new File(filePath));
	}

	public boolean write(List<List<String>> list) throws IOException {
		return write(list, LINE_END);
	}

	public boolean write(List<List<String>> list, String symbol) throws IOException {
		if (list == null) {
			System.out.println("list为空");
			return false;
		}

		int symbolLength = symbol.length();
		for (List<String> row : list) {
			if (row == null) {
				System.out.println("row为空");
				return false;
			}

			int symbolNum = 0;
			StringBuilder line = new StringBuilder();
			for (int i = 0; i < row.size(); i++) {
				String content = row.get(i);
				if (content == null) {
					System.out.println("content为空");
					return false;
				}

				if (i > 0) {
					line.append(symbol);
					symbolNum++;
				}
				line.append(content);
			}
			if (line.length() != symbolLength * symbolNum)
				out.write(line.toString());
			out.newLine();
		}
		return true;
	}

	public <T extends OutputEntity<?>> boolean write(T entity) throws IOException {
		return write(entity, LINE_END);
	}

	public <T extends OutputEntity<?>> boolean write(T entity, String symbol) throws IOException {
		if (entity == null) {
			System.out.println("entity为空");
			return false;
		}

		List<?> list = entity.toList();
		if (list == null) {
			System.out.println("list为空");
			return false;
		}

		int symbolLength = symbol.length();
		int symbolNum = 0;
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			if (obj == null) {
				System.out.println("obj为空");
				return false;
			}

			if (obj instanceof OutputEntity<?>) {
				if (!write((OutputEntity<?>) obj, symbol))
					return false;
				continue;
			}
			if (!(obj instanceof String)) {
				System.out.println("obj类型错误");
				return false;
			}

			if (i > 0) {
				line.append(symbol);
				symbolNum++;
			}
			line.append(String.valueOf(obj));
		}
		if (line.length() != symbolLength * symbolNum)
			out.write(line.toString());
		out.newLine();
		return true;
	}

	@Override
	public void close() throws IOException {
		out.close();
	}
}
