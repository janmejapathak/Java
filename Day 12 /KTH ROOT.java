import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) {
            long n = sc.nextLong();
            int k = sc.nextInt();
            
            long low = 1, high = n, ans = 0;
            
            while(low <= high) {
                long mid = low + (high - low) / 2;
                
                if(isValid(mid, k, n)) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            System.out.println(ans);
        }
    }
    
    static boolean isValid(long base, int exp, long limit) {
        long result = 1;
        
        for(int i = 0; i < exp; i++) {
            if(result > limit / base) return false;
            result *= base;
        }
        
        return true;
    }
}
