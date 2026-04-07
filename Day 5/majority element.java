public  class  arry{
    public static void main(String[] args) {
        int [] arr = {1,1,1,12,1,2,2,23,2,2,2,2,2};
        int n = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                n = arr[i];
            }if (arr[i] == n) {
                count++;
            }
             else {
                count--;
            }
        }
        System.out.println("Majority element is " + n);

    }
}
