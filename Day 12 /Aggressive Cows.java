// You are given n stalls positioned at specific distances along a straight line.Your task is to place c cows in these stalls such that the minimum distance betweeany two cows is maximized.


// Input Format
// The first line contains two integers n (number of stalls) and c (number of cows).
// The second line contains n integers, x1, x2, …, xn, representing the positions of the stalls.

// Constraints
// 2 ≤ n ≤ 105 (number of stalls)
// 2 ≤ c ≤ n (number of cows)
// 1 ≤ xi ≤ 109 (stall positions)
// xi are guaranteed to be unique.

// Output Format
// Output a single integer: the maximum minimum distance between any two cows.


// Sample Input
// 5 3
// 1 2 9 4 8
// Sample Output
// 3
// Explanation
// The stalls are at positions [1, 2, 4, 8, 9] (sorted).. Placing the cows at positions [1, 4, 8] gives a minimum distance of 3,which is the maximum achievable.

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int low = 1;
        int high = arr[n - 1] - arr[0];
        int ans = 0;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(canPlace(arr, n, c, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.print(ans);
    }

    public static boolean canPlace(int[] arr, int n, int c, int dist) {
        int cows = 1;
        int lastPos = arr[0];

        for(int i = 1; i < n; i++) {
            if(arr[i] - lastPos >= dist) {
                cows++;
                lastPos = arr[i];
            }

            if(cows >= c) return true;
        }

        return false;
    }
}
