
// BINARY SEARCH

import java.util.*;

public class sec {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter sorted elements:");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int start = 0, end = n - 1, ans = -1;

        while(start <= end){
            int mid = (start + end)/2;

            if(arr[mid] == target){
                ans = mid;
                break;
            }
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println("Index: " + ans);
    }
}
