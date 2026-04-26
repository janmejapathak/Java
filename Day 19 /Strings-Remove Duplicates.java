// Take as input S, a string. Write a function that removes all consecutive duplicates. Print the value returned.


// Input Format
// String


// Constraints
// A string of length between 1 to 1000


// Output Format
// String


// Sample Input
// aabccba
// Sample Output
// abcba
// Explanation
// For the given example, "aabccba", Consecutive Occurrence of a is 2, b is 1, and c is 2.

// After removing all of the consecutive occurences, the Final ans will be : - "abcba".


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String ans = "";
        ans = ans + s.charAt(0);

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){
                ans = ans + s.charAt(i);
            }
        }

        System.out.println(ans);
    }
}
