package leetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/distant-barcodes/
 * 调整数组使任意位置和前后值不等
 */
public class DistantBarcodesV2 {

    private int length;

    private boolean[] visited;

    Deque<Integer> stack = new LinkedList<>();

    public int[] rearrangeBarcodes(int[] barcodes) {
        length = barcodes.length;
        if (3 > length) {
            return barcodes;
        }
        visited = new boolean[length];

        this.dfs(barcodes, 0);
        return stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private boolean dfs(int[] barcodes, int cur) {
        if (cur == length) {
            return true;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] || 0 < cur && stack.element() == barcodes[i]) {
                continue;
            }
            visited[i] = true;
            stack.push(barcodes[i]);
            if (this.dfs(barcodes, cur + 1)) {
                return true;
            }
            stack.pop();
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] barcodes = {1, 1, 1, 2, 2, 2, 1};
        System.out.println(Arrays.toString(new DistantBarcodesV2().rearrangeBarcodes(barcodes)));
    }
}
