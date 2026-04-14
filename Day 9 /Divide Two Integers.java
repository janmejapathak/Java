public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert to long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        while (a >= b) {
            long temp = b;
            int multiple = 1;

            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }

        // Handle sign
        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        return result;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;

        int result = divide(dividend, divisor);
        System.out.println("Quotient: " + result);
    }
}
