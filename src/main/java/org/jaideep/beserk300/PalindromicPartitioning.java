package org.jaideep.beserk300;

import java.util.*;

public class PalindromicPartitioning {

    static int helper(String s,int index,List<String> temp,boolean[][] dp){
        if(index==s.length()){
            return temp.size()-1;
        }

        int min = Integer.MAX_VALUE;
        for(int i=index;i<s.length();i++){
            if(dp[index][i]){
                temp.add(s.substring(index,i+1)); //include
                int curr = helper(s,i+1,temp,dp);
                if(curr<min) min = curr;
                temp.remove(temp.size()-1); //exclude
            }
        }

        return min;
    }

    static int palPartition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // step1: single characters are palindromes
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }

        // step2: check substrings of length 2
        for(int i=0;i<n-1;i++){
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }

        // step3: substrings of length >= 3
        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                dp[i][j] = (dp[i+1][j-1] && s.charAt(i) == s.charAt(j));
            }
        }

        // DP for minimum cuts
        int[] cut = new int[n];
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                cut[i] = 0; // no cut needed if s[0..i] is palindrome
            } else {
                cut[i] = i; // worst case: cut between every char
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        cut[i] = Math.min(cut[i], cut[j] + 1);
                    }
                }
            }
        }

        return cut[n - 1];
    }

    public static void main(String[] args) {
        // Sample test cases
        String s1 = "ababbbabbababa";
        String s2 = "aab";
        String s3 = "racecar";
        String s4 = "banana";

        System.out.println("Minimum cuts for \"" + s1 + "\": " + palPartition(s1));
        System.out.println("Minimum cuts for \"" + s2 + "\": " + palPartition(s2));
        System.out.println("Minimum cuts for \"" + s3 + "\": " + palPartition(s3));
        System.out.println("Minimum cuts for \"" + s4 + "\": " + palPartition(s4));
    }
}
