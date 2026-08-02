public class StringTool {
    public static void main(String[] args) {
        if (args.length < 1) {
            printHelp();
            return;
        }
        String command = args[0].toLowerCase();
        switch (command) {
            case "reverse" -> {
                if (args.length < 2) {
                    System.out.println("Error: Missing text for 'reverse'.");
                    return;
                }
                System.out.println(reverse(args[1]));
            }
            case "palindrome" -> {
                if (args.length < 2) {
                    System.out.println("Error: Missing text for 'palindrome'.");
                    return;
                }
                System.out.println(isPalindrome(args[1]) ? "Yes, it's a palindrome." : "No, it's not a palindrome.");
            }
            case "count" -> {
                if (args.length < 2) {
                    System.out.println("Error: Missing text for 'count'.");
                    return;
                }
                int[] stats = countCharacters(args[1]);
                System.out.printf("Characters: %d | Words: %d | Lines: %d%n", stats[0], stats[1], stats[2]);
            }
            case "toggle" -> {
                if (args.length < 2) {
                    System.out.println("Error: Missing text for 'toggle'.");
                    return;
                }
                System.out.println(toggleCase(args[1]));
            }
            case "help" -> printHelp();
            default -> {
                System.out.println("Unknown command: " + command);
                printHelp();
            }
        }
    }

    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public static int[] countCharacters(String input) {
        int chars = input.length();
        int words = input.isEmpty() ? 0 : input.trim().split("\\s+").length;
        int lines = input.isEmpty() ? 0 : input.split("\n").length;
        return new int[]{chars, words, lines};
    }

    public static String toggleCase(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            else sb.append(c);
        }
        return sb.toString();
    }

    private static void printHelp() {
        System.out.println("""
                StringTool - A string utility tool
                Commands:
                  reverse   <text>   - Print the reversed text
                  palindrome <text>   - Check if text is a palindrome
                  count     <text>   - Count chars, words, and lines
                  toggle    <text>   - Toggle case (upper↔lower)
                  help               - Show this help
                Examples:
                  java StringTool.java reverse "hello"
                  java StringTool.java palindrome "Never odd or even"
                  java StringTool.java count "Hello\\nWorld"
                """);
    }
}
