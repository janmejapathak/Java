
// ARMSTRONG NUMBER

 import java.util.*;

public class sec {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int original = n, sum = 0;
        int digits = String.valueOf(n).length();

        while(n > 0){
            int d = n % 10;
            sum += Math.pow(d, digits);
            n /= 10;
        }

        if(sum == original)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not Armstrong");
    }
}
