// Given a string s, find the length of the longest substring without repeating characters.


// Input Format
// Input string


// Constraints
// 0<=|s|<=10000


// Output Format
// Length of longest substring with non repeating characters


// Sample Input
// ABDEFGABEF
// Sample Output
// 6
// Explanation
// For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] freq = new int[256];

        int left = 0, max = 0;

        for(int right = 0; right < s.length(); right++){

            freq[s.charAt(right)]++;

            while(freq[s.charAt(right)] > 1){
                freq[s.charAt(left)]--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}
