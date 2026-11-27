import  java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] dp = new int[budget + 1];

        for (int[] item : items) {
            int f = item[0], p = item[1];
            int free = 0;
            for (int[] other : items) {
                if (other[0] % f == 0) free++;
            }

            for (int b = budget; b >= p; b--) {
                dp[b] = Math.max(dp[b], dp[b - p] + free);
            }
            for (int b = p; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - p] + 1);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}