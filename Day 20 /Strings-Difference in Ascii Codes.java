// Take as input S, a string. Write a program that inserts between each pair of characters the difference between their ascii codes and print the ans.


// Input Format
// String


// Constraints
// Length of String should be between 2 to 1000.


// Output Format
// String


// Sample Input
// acb
// Sample Output
// a2c-1b
// Explanation
// For the sample case, the Ascii code of a=97 and c=99 ,the difference between c and a is 2.Similarly ,the Ascii code of b=98 and c=99 and their difference is -1. So the ans is a2c-1b.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String result = "";

        for (int i = 0; i < s.length() - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);

            result = result + current;

            int diff = next - current;
            result = result + diff;
        }

        result = result + s.charAt(s.length() - 1);

        System.out.println(result);
    }
}
