
// ARRAY TARGET SUM

import java.util.*;

public class sec {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        boolean found = false;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] + arr[j] == target){
                    System.out.println("Pair: " + arr[i] + ", " + arr[j]);
                    found = true;
                }
            }
        }

        if(!found) System.out.println("No pair found");
    }
}
