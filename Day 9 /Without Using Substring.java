public class SubStringWithoutMethod {
    public static void main(String[] args) {
        String str = "ABC";
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                }
                System.out.println();
            }
        }
    }
}
