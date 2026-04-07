
import java.util.*;

public class restartfun{

   public static void Fibonacci(int n){
      int prev0 = 0;
      int prev1 = 1;

      System.out.print(prev0 + " " + prev1 + " ");

      for(int i = 3; i <= n; i++){
         int next = prev0 + prev1;
         System.out.print(next + " ");

         prev0 = prev1;
         prev1 = next;
      }
   }

   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      Fibonacci(n);
   }
}
