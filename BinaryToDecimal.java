
   public class restartfun{
   public static int btod(int n ){
    int d = 0;
    int power = 0;
    while(n > 0){
        int last = n % 10;
        int power = 1;
          for(int i = 0; i < power; i++){
            power = power * 2;
          }
        d = d + last * power;
        power++;
        n = n / 10;
    }
    return d;
   }
    public static void main(String[]args){
              Scanner sc = new Scanner(System.in);
              int n = sc.nextInt();
        System.out.println(btod(n));   
    }
   }
