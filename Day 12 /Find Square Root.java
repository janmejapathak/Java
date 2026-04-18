import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();

        long low = 0, high = x, ans = 0;

        while(low <= high) {
            long mid = (low + high) / 2;

            if(mid * mid == x) {
                System.out.print(mid);
                return;
            } 
            else if(mid * mid < x) {
                ans = mid;
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        System.out.print(ans);
    }
}
