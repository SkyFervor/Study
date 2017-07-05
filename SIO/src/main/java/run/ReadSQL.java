package run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import core.FileOutput;

public class ReadSQL {
	public static void main(String args[]) throws IOException {
		File file = new File("D:\\1.sql");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		List<List<String>> data = new LinkedList<>();
		String line = null;
		while ((line = br.readLine()) != null) {
			data.add(line(line));
		}
		br.close();
		

		FileOutput fo = new FileOutput("D:\\2.sql");
		fo.write(data);
		fo.close();
	}

	public static List<String> line(String line) {
		List<String> list = new LinkedList<>();
		String[] data = line.substring(line.indexOf("VALUES") + 8, line.length() - 1).split(",");
		list.add(data[6]);
		list.add(data[7]);
		list.add(data[8]);
		list.add(data[9]);
		list.add(data[10]);
		list.add(data[11]);
		list.add(data[12]);
		list.add(data[13]);
		list = doChange(list);
		System.out.println(list);
		return list;
	}

	public static List<String> doChange(List<String> list) {
		List<String> newList = new LinkedList<>();
		for (String s : list) {
			if (s.startsWith("N'"))
				s = s.substring(2);
			else if (s.startsWith(" N'"))
				s = s.substring(3);
			
			if (s.endsWith("'"))
				s = s.substring(0, s.length() - 1);
			
			newList.add(s);
		}
		return newList;
	}
}
