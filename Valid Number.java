// Given a string s, return whether s is a valid number.

// For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".

// Formally, a valid number is defined using one of the following definitions:

// An integer number followed by an optional exponent.
// A decimal number followed by an optional exponent.
// An integer number is defined with an optional sign '-' or '+' followed by digits.

// A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:

// Digits followed by a dot '.'.
// Digits followed by a dot '.' followed by digits.
// A dot '.' followed by digits.
// An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.

// The digits are defined as one or more digits.

 

// Example 1:

// Input: s = "0"

// Output: true

// Example 2:

// Input: s = "e"

// Output: false

// Example 3:

// Input: s = "."

// Output: false

 

// Constraints:

// 1 <= s.length <= 20
// s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.




class Solution {
    public boolean isNumber(String s) {
        boolean hasDigit = false;
        boolean hasDot = false;
        boolean hasE = false;
        boolean digitAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                hasDigit = true;

                if (hasE) {
                    digitAfterE = true;
                }
            }

            else if (ch == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            }

            else if (ch == 'e' || ch == 'E') {
                if (hasE || !hasDigit) {
                    return false;
                }

                hasE = true;
                digitAfterE = false;
            }

            else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            else {
                return false;
            }
        }

        return hasDigit && digitAfterE;
    }
}
