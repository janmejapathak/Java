class Solution {
    // Mapping of digits to letters
    String[] map = {
        "", "",      // 0,1
        "abc", "def", // 2,3
        "ghi", "jkl", // 4,5
        "mno", "pqrs",// 6,7
        "tuv", "wxyz" // 8,9
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String digits, int index,
                           StringBuilder curr, List<String> ans) {

        // Base case: one complete combination formed
        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        // Current digit
        int digit = digits.charAt(index) - '0';
        String letters = map[digit];

        // Try every letter
        for (char ch : letters.toCharArray()) {
            curr.append(ch);                    // choose
            backtrack(digits, index + 1, curr, ans); // explore
            curr.deleteCharAt(curr.length() - 1);    // undo
        }
    }
}
