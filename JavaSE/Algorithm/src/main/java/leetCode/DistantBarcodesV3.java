package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/distant-barcodes/
 * 调整数组使任意位置和前后值不等
 */
public class DistantBarcodesV3 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        if (null == barcodes || 3 > barcodes.length) {
            return barcodes;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int barcode : barcodes) {
            countMap.put(barcode, countMap.getOrDefault(barcode, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((barcode1, barcode2) -> countMap.get(barcode2) - countMap.get(barcode1));
        for (int i : countMap.keySet()) {
            queue.offer(i);
        }

        int[] result = new int[barcodes.length];
        int index = 0;
        while (1 < queue.size()) {
            int a = queue.poll();
            int b = queue.poll();
            result[index++] = a;
            result[index++] = b;

            int countA = countMap.get(a);
            int countB = countMap.get(b);
            if (countA > 0) {
                countMap.put(a, countA - 1);
                if (countA - 1 > 0) {
                    queue.offer(a);
                }
            }
            if (countB > 0) {
                countMap.put(b, countB - 1);
                if (countB - 1 > 0) {
                    queue.offer(b);
                }
            }
        }
        if (!queue.isEmpty()) {
            result[index] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "&amp;";
        System.out.println(s.substring(0, 5));
        int[] barcodes = {1, 1, 1, 2, 2, 2, 2, 1};
        System.out.println(Arrays.toString(new DistantBarcodesV3().rearrangeBarcodes(barcodes)));
    }

}
