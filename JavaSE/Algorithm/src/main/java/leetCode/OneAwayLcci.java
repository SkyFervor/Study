package leetCode;

/**
 * https://leetcode-cn.com/problems/one-away-lcci
 * 两字符串是否只有1个字符的差异
 */
public class OneAwayLcci {
    public boolean oneEditAway(String first, String second) {
        first = first + "1";
        second = second + "1";

        if (first.length() < second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }
        if (first.length() != second.length() && first.length() != second.length() + 1) {
            return false;
        }
        if (first.equals(second)) {
            return true;
        }

        int i = 0;
        while (i < first.length()) {
            if (first.charAt(i) != second.charAt(i)) {
                break;
            }
            i++;
        }
        if (this.stringEquals(first, i + 1, second, i + 1)) {
            return true;
        }
        return this.stringEquals(first, i + 2, second, i + 1);
    }

    private boolean stringEquals(String first, int i, String second, int j) {
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return i == first.length() && j == second.length();
    }

    public static void main(String[] args) {
        System.out.println(new OneAwayLcci().oneEditAway("teacher", "bleacher"));
    }
}
