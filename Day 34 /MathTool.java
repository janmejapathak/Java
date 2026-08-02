public class MathTool {
    public static void main(String[] args) {
        if (args.length < 2) {
            printHelp();
            return;
        }
        String command = args[0].toLowerCase();
        String numStr = args[1];
        try {
            long n = Long.parseLong(numStr);
            switch (command) {
                case "factorial" -> System.out.println(factorial(n));
                case "prime" -> System.out.println(isPrime(n) ? "Prime" : "Not prime");
                case "fibonacci" -> System.out.println(fibonacci(n));
                case "gcd" -> {
                    if (args.length < 3) {
                        System.out.println("Error: gcd needs two numbers.");
                        return;
                    }
                    long m = Long.parseLong(args[2]);
                    System.out.println(gcd(n, m));
                }
                default -> {
                    System.out.println("Unknown command: " + command);
                    printHelp();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please provide valid integers.");
        }
    }

    public static long factorial(long n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        long result = 1;
        for (long i = 2; i <= n; i++) result *= i;
        return result;
    }

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static long fibonacci(long n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        for (long i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    private static void printHelp() {
        System.out.println("""
                MathTool - A math utility tool
                Commands:
                  factorial <n>     - Compute n!
                  prime     <n>     - Check if n is prime
                  fibonacci <n>     - Compute the n-th Fibonacci number (0-based)
                  gcd       <a> <b> - Compute GCD of a and b
                Examples:
                  java MathTool.java factorial 5
                  java MathTool.java prime 17
                  java MathTool.java fibonacci 10
                  java MathTool.java gcd 48 18
                """);
    }
}
