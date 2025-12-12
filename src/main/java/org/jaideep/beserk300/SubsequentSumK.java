package org.jaideep.beserk300;
import java.util.Arrays;

public class SubsequentSumK {
    public static boolean checkSubsequenceSum(int N, int[] arr, int target) {
        // dp[n][target] = -1 (not computed), 0 (false), 1 (true)
        int[][] dp = new int[N + 1][target + 1];

        // Fill each row with -1 using Arrays.fill
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(arr, N, target, dp);
    }

    private static boolean helper(int[] arr, int n, int target, int[][] dp) {
        // Base cases
        if (target == 0) return true;   // ✅ Found solution → prune immediately
        if (n == 0) return false;

        // Already computed?
        if (dp[n][target] != -1) {
            return dp[n][target] == 1;
        }

        // Exclude current element
        if (helper(arr, n - 1, target, dp)) {
            dp[n][target] = 1;
            return true;   // ✅ prune immediately
        }

        // Include current element if possible
        if (arr[n - 1] <= target && helper(arr, n - 1, target - arr[n - 1], dp)) {
            dp[n][target] = 1;
            return true;   // ✅ prune immediately
        }

        dp[n][target] = 0;
        return false;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println(checkSubsequenceSum(arr1.length, arr1, target1)); // true

        int[] arr2 = {2, 3, 5, 7, 9};
        int target2 = 100;
        System.out.println(checkSubsequenceSum(arr2.length, arr2, target2)); // false
    }
}
