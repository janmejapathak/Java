// Kartik Bhaiya has a string consisting of only 'a' and 'b' as the characters. Kartik Bhaiya describes perfectness of a string as the maximum length substring of equal characters. Kartik Bhaiya is given a number k which denotes the maximum number of characters he can change. Find the maximum perfectness he can generate by changing no more than k characters.


// Input Format
// The first line contains an integer denoting the value of K. The next line contains a string having only ‘a’ and ‘b’ as the characters.


// Constraints
// 2 ≤ N ≤ 10^6


// Output Format
// A single integer denoting the maximum perfectness achievable.


// Sample Input
// 2
// abba
// Sample Output
// 4
// Explanation
// We can swap the a's to b using the 2 swaps and obtain the string "bbbb". This would have all the b's and hence the answer 4.
// Alternatively, we can also swap the b's to make "aaaa". The final answer remains the same for both cases.


import java.util.*;

public class Main {

    public static int solve(String s, int k, char ch) {

        int i = 0, j = 0, count = 0, ans = 0;

        while(j < s.length()) {

            if(s.charAt(j) != ch) count++;

            while(count > k) {
                if(s.charAt(i) != ch) count--;
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        String s = sc.next();

        int ans1 = solve(s, k, 'a');
        int ans2 = solve(s, k, 'b');

        System.out.println(Math.max(ans1, ans2));
    }
}
