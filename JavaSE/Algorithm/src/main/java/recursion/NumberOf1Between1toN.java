package recursion;

/**
 * 1-n中1出现的总次数
 */
public class NumberOf1Between1toN {
	public static int numberOf1(String num) {
		if (Integer.parseInt(num) == 0)
			return 0;

		int length = num.length();
		int first = num.charAt(0) - '0';

		// 个位，到达边界
		if (length == 1) {
			if (first > 0)
				return 1; // 1-9中只有一个1
			return 0; // 个位为0，没有1
		}

		int count = 0;
		/*1346-21345*/
		// 最高位出现的1
		if (first > 1)
			count += Math.pow(10, length - 1); // 10000-19999，10^(位数-1)个1
		else if (first == 1)
			count += Integer.parseInt(num.substring(1)) + 1; // 1000-1345，除去最高位+1个1

		// 除最高位之外的位数出现的1
		count += first * (length - 1) * Math.pow(10, length - 2); // 1346-21345，最高位*C(length-1,1)*10^(length-2)
		// 分解为1346-11345和11346-21346，选择其中一位为1，其余位数可在0-9中任选一个

		/*1-1345*/
		count += numberOf1(num.substring(1));

		return count;
	}

	public static void main(String[] args) {
		int n1 = 21345;
		System.out.println(numberOf1(String.valueOf(n1)));

		int n2 = 10000;
		System.out.println(numberOf1(String.valueOf(n2)));
	}
}
