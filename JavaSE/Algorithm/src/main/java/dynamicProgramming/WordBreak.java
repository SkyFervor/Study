package dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args) {
		String s = "programcreek";
		Set<String> dict = new HashSet<String>();
		dict.add("programcree");
		dict.add("program");
		dict.add("creek");

		System.out.println(wordBreak(s, dict));
	}

	public static boolean wordBreak(String s, Set<String> dict) {
		boolean[] t = new boolean[s.length() + 1];
		t[0] = true;

		for (int i = 0; i < s.length(); i++) {
			if (!t[i])
				continue;

			for (String word : dict) {
				int end = i + word.length();

				if (end > s.length())
					continue;
				if (t[end])
					continue;
				if (s.substring(i, end).equals(word))
					t[end] = true;
			}
		}

		return t[s.length()];
	}

	static class NaiveApproach {
		public static boolean wordBreak(String s, Set<String> dict) {
			return wordBreakHelper(s, dict, 0);
		}

		public static boolean wordBreakHelper(String s, Set<String> dict, int start) {
			if (start == s.length())
				return true;

			for (String word : dict) {
				int len = word.length();
				int end = start + len;

				if (end > s.length())
					continue;

				if (s.substring(start, end).equals(word))
					if (wordBreakHelper(s, dict, end))
						return true;
			}
			return false;
		}
	}
}
