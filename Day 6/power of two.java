import java.util.*;

public class sec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        if(isPowerOfTwo(n)){
            System.out.println("Yes, Power of 2");
        } else {
            System.out.println("No, Not a Power of 2");
        }
    }

    public static boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;

        return (n & (n - 1)) == 0;
    }
}
