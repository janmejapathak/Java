public class arry{
    public static void main(String[] args) {
        int [] arr = {2,45,3,5,6,78};
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]< min) {
                min = arr[i];
            }
            
        }
        System.out.println("min = " + min);
            }
}

