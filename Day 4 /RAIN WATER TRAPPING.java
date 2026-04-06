
// RAIN WATER TRAPPING
import java.util.*;

public class sec {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] h = new int[n];

        for(int i = 0; i < n; i++){
            h[i] = sc.nextInt();
        }

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while(left <= right){
            if(h[left] < h[right]){
                if(h[left] >= leftMax)
                    leftMax = h[left];
                else
                    water += leftMax - h[left];
                left++;
            } else {
                if(h[right] >= rightMax)
                    rightMax = h[right];
                else
                    water += rightMax - h[right];
                right--;
            }
        }

        System.out.println(water);
    }
}
