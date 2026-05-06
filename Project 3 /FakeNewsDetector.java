import java.util.*;

public class Main {
    static String[] fakeKeywords = {
        "shocking", "viral", "breaking", "100% cure", "guaranteed",
        "click here", "urgent", "free money"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter news text:");
        String news = sc.nextLine().toLowerCase();

        int score = 0;

        for (String keyword : fakeKeywords) {
            if (news.contains(keyword)) {
                score++;
            }
        }

        System.out.println("\nAnalysis Result:");

        if (score >= 3) {
            System.out.println("⚠️ Likely Fake News");
        } else if (score == 1 || score == 2) {
            System.out.println("⚠️ Suspicious News");
        } else {
            System.out.println("✅ Looks Real");
        }

        System.out.println("Fake Score: " + score);
    }
}
