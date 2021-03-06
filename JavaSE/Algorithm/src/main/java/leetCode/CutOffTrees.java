package leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/cut-off-trees-for-golf-event/
 * 按树高顺序寻径砍树
 */
public class CutOffTrees {
    private int length_i;
    private int length_j;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int[][] arr = {{69438,55243,0,43779,5241,93591,73380},{847,49990,53242,21837,89404,63929,48214},{90332,49751,0,3088,16374,70121,25385},{14694,4338,87873,86281,5204,84169,5024},{31711,47313,1885,28332,11646,42583,31460},{59845,94855,29286,53221,9803,41305,60749},{95077,50343,27947,92852,0,0,19731},{86158,63553,56822,90251,0,23826,17478},{60387,23279,78048,78835,5310,99720,0},{74799,48845,60658,29773,96129,90443,14391},{65448,63358,78089,93914,7931,68804,72633},{93431,90868,55280,30860,59354,62083,47669},{81064,93220,22386,22341,95485,20696,13436},{50083,0,89399,43882,0,13593,27847},{0,12256,33652,69301,73395,93440,0},{42818,87197,81249,33936,7027,5744,64710},{35843,0,99746,52442,17494,49407,63016},{86042,44524,0,0,26787,97651,28572},{54183,83466,96754,89861,84143,13413,72921},{89405,52305,39907,27366,14603,0,14104},{70909,61104,70236,30365,0,30944,98378},{20124,87188,6515,98319,78146,99325,88919},{89669,0,64218,85795,2449,48939,12869},{93539,28909,90973,77642,0,72170,98359},{88628,16422,80512,0,38651,50854,55768},{13639,2889,74835,80416,26051,78859,25721},{90182,23154,16586,0,27459,3272,84893},{2480,33654,87321,93272,93079,0,38394},{34676,72427,95024,12240,72012,0,57763},{97957,56,83817,45472,0,24087,90245},{32056,0,92049,21380,4980,38458,3490},{21509,76628,0,90430,10113,76264,45840},{97192,58807,74165,65921,45726,47265,56084},{16276,27751,37985,47944,54895,80706,2372},{28438,53073,0,67255,38416,63354,69262},{23926,75497,91347,58436,73946,39565,10841},{34372,69647,44093,62680,32424,69858,68719},{24425,4014,94871,1031,99852,88692,31503},{24475,12295,33326,37771,37883,74568,25163},{0,18411,88185,60924,29028,69789,0},{34697,75631,7636,16190,60178,39082,7052},{24876,9570,53630,98605,22331,79320,88317},{27204,89103,15221,91346,35428,94251,62745},{26636,28759,12998,58412,38113,14678,0},{80871,79706,45325,3861,12504,0,4872},{79662,15626,995,80546,64775,0,68820},{25160,82123,81706,21494,92958,33594,5243}};
        //int[][] arr = {{65373036,2456655,62996182,77165169,11057485,52535331,63698310,27129253,84289874},{18570009,29409292,57221123,27322139,5967050,25641409,59807085,41287955,67002016},{59925393,84342153,95847740,96720219,95877289,6633239,96769252,68980562,99717888},{38092644,69430191,46393504,75242757,38524238,92687163,72390599,86031769,97616262},{63895259,13582559,38270398,10833444,47844868,78209342,89000764,505213,82251326},{99638437,70547733,81264676,80087375,33825268,19488243,21385757,13931827,81384999},{78687499,27054031,82935633,59857240,16454994,14764718,15186553,54119613,24432831},{66192618,83872603,19246010,82241107,14604727,65304619,98680361,48033577,56249633},{82869596,12875294,85175067,6220745,31624067,97537659,73504597,90040176,90033521}};
        //int[][] arr = {{1, 2, 3}, {0, 0, 4}, {7, 6, 5}};
        List<List<Integer>> list = Arrays.stream(arr)
                .map(a -> Arrays.stream(a).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(new CutOffTrees().cutOffTree(list));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> treeMap = new PriorityQueue<>(Comparator.comparingInt(tree -> forest.get(tree[0]).get(tree[1])));

        length_i = forest.size();
        length_j = forest.get(0).size();
        for (int i = 0; i < length_i; i++) {
            for (int j = 0; j < length_j; j++) {
                if (0 != forest.get(i).get(j)) {
                    treeMap.add(new int[]{i, j});
                }
            }
        }

        int result = 0;
        int[] start = new int[]{0, 0};
        while(!treeMap.isEmpty()) {
            int[] dest = treeMap.poll();
            int steps = this.bfs(forest, start, dest);
            if (-1 == steps) {
                return -1;
            }
            start = dest;
            result += steps;
        }
        return result;
    }

    private int bfs(List<List<Integer>> forest, int[] start, int[] dest) {
        if (start[0] == dest[0] && start[1] == dest[1]) {
            return 0;
        }
        boolean[][] visited = new boolean[length_i][length_j];
        visited[start[0]][start[1]] = true;

        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        do {
            steps++;
            for (int i = 0, length = queue.size(); i < length; i++) {
                int[] cur = queue.poll();

                for (int[] direction : directions) {
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if (0 <= x && x < length_i && 0 <= y && y < length_j && !visited[x][y]) {
                        if (x == dest[0] && y == dest[1]) {
                            return steps;
                        }
                        if (0 != forest.get(x).get(y)) {
                            queue.offer(new int[]{x, y});
                            visited[x][y] = true;
                        }
                    }
                }
            }
        } while (!queue.isEmpty());
        return -1;
    }
}
