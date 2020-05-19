package leetCode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/distant-barcodes/
 * 调整数组使任意位置和前后值不等
 */
public class DistantBarcodes {

    private int length;

    public int[] rearrangeBarcodes(int[] barcodes) {
        length = barcodes.length;
        if (3 > length) {
            return barcodes;
        }

        int i = 1;
        while (length > i) {
            if (barcodes[i - 1] != barcodes[i]) {
                i++;
                continue;
            }
            if (!this.resetCur(barcodes, i, true)) {
                break;
            }
        }

        i = length - 2;
        while (0 <= i) {
            if (barcodes[i] != barcodes[i + 1]) {
                i--;
                continue;
            }
            if (!this.resetCur(barcodes, i, false)) {
                break;
            }
        }
        return barcodes;
    }

    private boolean resetCur(int[] barcodes, int cur, boolean positive) {
        if (0 > cur || cur >= length) {
            return false;
        }
        if (positive) {
            for (int i = cur + 1; i < length; i++) {
                if (barcodes[cur] == barcodes[i]) {
                    continue;
                }
                if (i < length - 1 && barcodes[cur] == barcodes[i + 1]) {
                    i++;
                    continue;
                }
                int temp = barcodes[cur];
                System.arraycopy(barcodes, cur + 1, barcodes, cur, i - cur);
                barcodes[i] = temp;
                return true;
            }
        } else {
            for (int i = cur - 1; i >= 0; i--) {
                if (barcodes[cur] == barcodes[i]) {
                    continue;
                }
                if (i > 0 && barcodes[cur] == barcodes[i - 1]) {
                    i--;
                    continue;
                }
                int temp = barcodes[cur];
                System.arraycopy(barcodes, i, barcodes, i + 1, cur - i);
                barcodes[i] = temp;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] barcodes = {1, 2, 2, 2, 1};
        System.out.println(Arrays.toString(new DistantBarcodes().rearrangeBarcodes(barcodes)));
    }
}
