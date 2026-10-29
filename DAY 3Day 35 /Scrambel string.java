// We can scramble a string s to get a string t using the following algorithm:

// If the length of the string is 1, stop.
// If the length of the string is > 1, do the following:
// Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
// Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
// Apply step 1 recursively on each of the two substrings x and y.
// Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.

 

// Example 1:

// Input: s1 = "great", s2 = "rgeat"
// Output: true
// Explanation: One possible scenario applied on s1 is:
// "great" --> "gr/eat" // divide at random index.
// "gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
// "gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at random index each of them.
// "g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.
// "r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
// "r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
// The algorithm stops now, and the result string is "rgeat" which is s2.
// As one possible scenario led s1 to be scrambled to s2, we return true.
// Example 2:

// Input: s1 = "abcde", s2 = "caebd"
// Output: false
// Example 3:

// Input: s1 = "a", s2 = "a"
// Output: true





class Solution {
    Boolean[][][] dp;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        dp = new Boolean[n][n][n + 1];
        return solve(s1, s2, 0, 0, n);
    }

    boolean solve(String s1, String s2, int i, int j, int len) {
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len)))
            return true;

        if (dp[i][j][len] != null)
            return dp[i][j][len];

        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int x : count) {
            if (x != 0)
                return dp[i][j][len] = false;
        }

        for (int k = 1; k < len; k++) {
            if (solve(s1, s2, i, j, k) &&
                solve(s1, s2, i + k, j + k, len - k))
                return dp[i][j][len] = true;

            if (solve(s1, s2, i, j + len - k, k) &&
                solve(s1, s2, i + k, j, len - k))
                return dp[i][j][len] = true;
        }

        return dp[i][j][len] = false;
    }
}
