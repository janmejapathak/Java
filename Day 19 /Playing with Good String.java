// A Good String is a string which contains only vowels (a,e,i,o,u) . Given a string S, print a single positive integer N where N is the length of the longest substring of S that is also a Good String.


// Input Format
// A string 'S' containing only lowercase English letters ('a' to 'z').


// Constraints
// Length of string < 10^5


// Output Format
// A single positive integer N, where N is the length of the longest sub-string of S that is also a Good String. If no valid Good String exists, print 0.


// Sample Input
// cbaeicde
// Sample Output
// 3
// Explanation
// Longest good substring is "aei"


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int count = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
                if(count > max) max = count;
            } else {
                count = 0;
            }
        }

        System.out.println(max);
    }
}
