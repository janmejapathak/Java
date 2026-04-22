import java.util.*;

public class ArrayAnalyzer {

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 30, 15};

        int max = arr[0];
        int min = arr[0];
        int sum = 0;

        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
            sum += num;
        }

        double avg = (double) sum / arr.length;

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average: " + avg);

        System.out.print("Reversed Array: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
