// Kartik Bhaiya and Kanak Bhaiya are discussing a special type of number, which they call a Coding Blocks Number (CB Number). A number qualifies as a CB Number based on the following criteria:

// 0 and 1 are not considered CB numbers.
// The following prime numbers are always CB numbers:
// 2, 3, 5, 7, 11, 13, 17, 19, 23, 29.
// Any other number is a CB number if it is not divisible by any of the numbers listed in point (2).
// The Challenge
// Kartik Bhaiya challenges Kanak Bhaiya with a problem:
// He provides a string of digits, and Kanak Bhaiya must determine the maximum number of CB numbers that can be extracted from it while following these constraints:

// 1. Non-overlapping Substrings:
// A CB number cannot be a substring or superstring of another chosen CB number.
// Example: In 4991, both 499 and 991 are CB numbers, but we can choose only one of them.
// 2. Valid Substring Selection:
// The CB number must be a contiguous substring of the given string.
// Example: In 481, we cannot select 41 as a CB number because 41 is not a contiguous substring of "481."
// 3. Maximization Goal:
// Since multiple solutions may exist, the goal is to find the maximum number of CB numbers that can be extracted from the given string.
// Kanak Bhaiya has a class of Launchpad students to teach and needs help solving this challenge. Assist him in finding the solution.


// Input Format
// First line contain size of the string.

// Next line is A string of digits.


// Constraints
// 1 <= Length of strings of digits <= 17


// Output Format
// Maximum number of CB numbers that can be formed.


// Sample Input
// 5
// 81615
// Sample Output
// 2
// Explanation
// For the string "81615"

// Digits	Possible Substrings
// 1-digit	8, 1, 6, 1, 5
// 2-digit	81, 16, 61, 15
// 3-digit	816, 161, 615
// 4-digit	8161, 1615
// 5-digit	81615

// Step 2: Identifying Valid CB Numbers

// We check each substring against CB number conditions:

// CB Numbers Found: 5, 61, 161
// Not CB Numbers: 8, 1, 6, 15, 81, 816, 615, 8161, 1615, 81615
// Numbers like 8, 6, and 81 are invalid as they are divisible by 2 or 3.
// 161 and 61 are valid as they are not divisible by any CB prime.
// Final Answer:

// The maximum number of CB numbers extracted from "81615" is: 2

// (Possible CB Numbers: 5, 161 or 5, 61)



import java.util.*;

public class Main {

    static int[] arr = {2,3,5,7,11,13,17,19,23,29};

    public static boolean isCB(long num) {

        if(num == 0 || num == 1) return false;

        for(int i = 0; i < arr.length; i++){
            if(num == arr[i]) return true;
        }

        for(int i = 0; i < arr.length; i++){
            if(num % arr[i] == 0) return false;
        }

        return true;
    }

    public static boolean check(boolean[] visited, int i, int j){
        for(int k = i; k <= j; k++){
            if(visited[k] == true) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int len = 1; len <= n; len++){

            for(int i = 0; i <= n - len; i++){

                int j = i + len - 1;

                String sub = s.substring(i, j+1);
                long num = Long.parseLong(sub);

                if(isCB(num) && check(visited, i, j)){
                    count++;

                    for(int k = i; k <= j; k++){
                        visited[k] = true;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
