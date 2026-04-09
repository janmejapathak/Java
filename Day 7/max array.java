public class arry{
    public static void main(String[] args) {
        int [] arr = {2,34,53,64};
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            
        }
        System.out.println("max = " + max);
    }
}
