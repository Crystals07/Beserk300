package org.jaideep.beserk300;

import org.jaideep.TestCase;

import java.util.Arrays;

public class CoinChangeProblem implements TestCase {

    private int minCoinsHelper(int[] coins, int target, int[] dp) {

        // base cases
        if (target == 0) return 0;   // zero coins needed
        if (target < 0) return -1;   // impossible

        // memo check
        if (dp[target] != -2) return dp[target];

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin > target) break;

            int res = minCoinsHelper(coins, target - coin, dp);

            if (res >= 0) {   // valid (not -1)
                min = Math.min(min, res + 1);
            }
        }

        // store result
        dp[target] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[target];
    }

    public int minCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -2); // -2 means "not computed yet"
        return minCoinsHelper(coins, target, dp);
    }

    @Override
    public String runTest(Object[] input) {
        int ans = minCoins((int[]) input[0], (int) input[1]);
        return "Min coin changes: " + ans;
    }
}
