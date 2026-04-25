// Take as input S, a string. Write a function that does basic string compression. Print the value returned. E.g. for input “aaabbccds” print out a3b2c2d1s1.


// Input Format
// A single String S


// Constraints
// 1 < = length of String < = 1000


// Output Format
// The compressed String.


// Sample Input
// aaabbccdsaa
// Sample Output
// a3b2c2d1s1a2
// Explanation
// In the given sample test case 'a' is repeated 3 times consecutively, 'b' is repeated twice, 'c' is repeated twice and 'd and 's' occurred only once.


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String ans = "";
        int count = 1;

        for(int i = 0; i < s.length() - 1; i++){

            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            } else {
                ans = ans + s.charAt(i) + count;
                count = 1;
            }
        }

        ans = ans + s.charAt(s.length()-1) + count;

        System.out.println(ans);
    }
}
