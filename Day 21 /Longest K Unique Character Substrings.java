// Jeetu Bhaiya has given you a string and you to print the size of the longest possible substring that has exactly k unique characters.
// If there is no possible substring then print -1.


// Input Format
// The first line of input contains an integer T denoting the no of test cases. Each test case contains two lines. The first line of each test case contains a string s and the next line contains an integer k.


// Constraints
// 1<=T<=100
// 1<=k<=10


// Output Format
// For each test case in a new line print the required output.


// Sample Input
// 2
// aaaa
// 1
// qmb
// 6
// Sample Output
// 4
// -1


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();

            int[] freq = new int[256];
            int left = 0, unique = 0, maxLen = -1;

            for (int right = 0; right < s.length(); right++) {
                if (freq[s.charAt(right)] == 0) {
                    unique++;
                }
                freq[s.charAt(right)]++;

                while (unique > k) {
                    freq[s.charAt(left)]--;
                    if (freq[s.charAt(left)] == 0) {
                        unique--;
                    }
                    left++;
                }

                if (unique == k) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }

            System.out.println(maxLen);
        }
    }
}
