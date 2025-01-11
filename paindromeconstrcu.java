/*
Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

 

Example 1:

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
Example 2:

Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.
Example 3:

Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= 105
*/
import java.util.HashMap;

class paindromeconstrcu {
    public boolean canConstruct(String s, int k) {
        // Step 1: Base cases
        if (k > s.length()) {
            return false; // Not enough characters to form k palindromes
        }
        if (k == s.length()) {
            return true; // Each character can be its own palindrome
        }
        
        // Step 2: Count character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Step 3: Count characters with odd frequencies
        int oddCount = 0;
        for (int freq : charCount.values()) {
            if (freq % 2 != 0) {
                oddCount++;
            }
        }
        
        // Step 4: Check if k is greater than or equal to the number of odd frequencies
        return k >= oddCount;
    }
}
