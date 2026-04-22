public class StringMaster {

    public static void main(String[] args) {
        String str = "madam";

        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("Reversed: " + reversed);

        if (str.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        int vowels = 0;
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                vowels++;
            }
        }

        System.out.println("Vowel Count: " + vowels);
    }
}
