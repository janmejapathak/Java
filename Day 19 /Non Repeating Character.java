// Given a string, find the first non-repeating character in it. For example, if the input string is “coding blocks”, then the output should be ‘d’ and if the input string is “coding”, then the output should be ‘c’.


// Input Format
// The first line contains T denoting the number of testcases. The following T lines contain the string S.


// Constraints
// String Length <100000


// Output Format
// For each testcase, print the first non repeating character present in string. Print -1 if there is no non repeating character.


// Sample Input
// 4
// codingblocks
// abbac
// java
// ccdd
// Sample Output
// d
// c
// j
// -1


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){

            String s = sc.next();
            int[] freq = new int[256];

            for(int i = 0; i < s.length(); i++){
                freq[s.charAt(i)]++;
            }

            char ans = '0';
            boolean found = false;

            for(int i = 0; i < s.length(); i++){
                if(freq[s.charAt(i)] == 1){
                    ans = s.charAt(i);
                    found = true;
                    break;
                }
            }

            if(found){
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }
        }
    }
}
