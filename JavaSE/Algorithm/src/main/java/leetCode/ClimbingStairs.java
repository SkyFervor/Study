package leetCode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯方法总数
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stairs = scanner.nextInt();

        if (3 > stairs) {
            System.out.println(stairs);
            return;
        }
        List<int[]> list = new ArrayList<>();
        int[] methods = new int[stairs];
        methods[0] = 1;
        methods[1] = 2;
        for (int i = 2; i < stairs; i++) {
            methods[i] = methods[i - 1] + methods[i - 2];
        }
        System.out.println(methods[stairs - 1]);
    }

    private void test() {
        Character c = 'a';
        Map<Character, Integer> map = new HashMap<>();
        map.merge(c, 1, Integer::sum);
    }
}
