import java.util.Scanner;
public class restartfun {
public static String getMinNumber(String s) {
        char[] digits = s.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            int d = digits[i] - '0';
            if (i == 0 && d == 9) {
                continue;
            }
            if (d >= 5) {
                digits[i] = (char) ((9 - d) + '0');
            }
        }
        return new String(digits);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getMinNumber(s));
    }
}
