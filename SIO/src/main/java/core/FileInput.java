package core;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import utility.UnicodeUtils;

public class FileInput implements Closeable {
	BufferedReader in;
	static final String LINE_END = "\r\n";

	public FileInput(File file) throws IOException {
		if (file == null || !file.exists())
			throw new IOException("文件未找到");
		this.in = new BufferedReader(new FileReader(file));
	}

	public FileInput(String filePath) throws IOException {
		this(new File(filePath));
	}

	public List<List<String>> read() throws IOException {
		return read(LINE_END);
	}

	public List<List<String>> read(String symbol) throws IOException {
		List<List<String>> list = new LinkedList<>();
		String line;
		while ((line = in.readLine()) != null) {
			List<String> row = new LinkedList<>(Arrays.asList(line.split(symbol)));
			list.add(row);
		}
		return list;
	}

	public List<Language> readLan(String symbol) throws IOException {
		List<Language> list = new LinkedList<>();
		String line;
		while ((line = in.readLine()) != null) {
			String[] str = line.split(symbol);
			Language lan = new Language();
			lan.setKey(str[0]);
			if (str.length == 1)
				lan.setValue(null);
			else {
				String s = str[1];
				if (s.indexOf("\\u") != -1) {
					s = UnicodeUtils.unicode2String(s);
				}
				lan.setValue(s);
			}
			list.add(lan);
		}
		return list;
	}

	@Override
	public void close() throws IOException {
		in.close();
	}

}
