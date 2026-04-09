public class restartnum{
    public static void main(String[]args){

    } 
}


Decimal to Binary conversion 
import java.util.*;
public class restartnum{
    public static void main(String[]args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int binary = 0;
      int place = 1;
      while(n > 0){
        int r = n%2;
        binary = binary + r*place;
        place = place*10;
        n = n/2;
      }
System.out.print(binary);
    }
}
