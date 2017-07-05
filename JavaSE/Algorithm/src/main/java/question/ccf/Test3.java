package question.ccf;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {
	protected static Map<String, Boolean> options = new HashMap<String, Boolean>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String format = sc.nextLine();
		int n = Integer.parseInt(sc.nextLine());
		String[] commands = new String[n];
		for (int i = 0; i < n; i++)
			commands[i] = sc.nextLine();
		sc.close();

		AnalysisFormat(format);
		for (int i = 0; i < n; i++)
			System.out.println("Case " + (i + 1) + ":" + AnalysisCommand(commands[i]));
	}

	protected static void AnalysisFormat(String format) {
		for (int i = 0; i < format.length(); i++) {
			char curChar = format.charAt(i);

			if (i < format.length() - 1 && format.charAt(i + 1) == ':')
				options.put("-" + curChar, true);
			else
				options.put("-" + curChar, false);
		}
	}

	protected static String AnalysisCommand(String commandString) {
		String[] command = commandString.split(" ");
		LinkedHashMap<String, String> results = new LinkedHashMap<String, String>();

		for (int i = 1; i < command.length; i++) {
			String curString = command[i];

			Boolean option = options.get(curString);
			if (option == null)
				break;

			if (!option) {
				results.put(curString, null);
				continue;
			}
			String nextString = command[i + 1];
			results.put(curString, nextString);
			i++;
		}

		String returnString = "";
		for (HashMap.Entry<String, String> result : results.entrySet()) {
			returnString += " " + result.getKey();
			if (result.getValue() != null)
				returnString += " " + result.getValue();
		}
		return returnString;
	}
}
