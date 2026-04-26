// Take as input S, a string. Write a function that toggles the case of all characters in the string. Print the value returned.


// Input Format
// String


// Constraints
// Length of string should be between 1 to 1000.


// Output Format
// String


// Sample Input
// abC
// Sample Output
// ABc
// Explanation
// Toggle Case means to change UpperCase character to LowerCase character and vice-versa.

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String ans = "";

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                ans = ans + (char)(ch - 32);
            } else {
                ans = ans + (char)(ch + 32);
            }
        }

        System.out.println(ans);
    }
}
