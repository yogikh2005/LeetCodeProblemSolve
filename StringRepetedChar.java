/*
Longest Substring Without Repeating Characters
*/

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in the set, shrink the window from the left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add the current character to the set and update max length
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println( solution.lengthOfLongestSubstring("abcabcbb"));  // Output: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));     // Output: 1
        System.out.println( solution.lengthOfLongestSubstring("pwwkew"));    // Output: 3
        System.out.println( solution.lengthOfLongestSubstring(""));          // Output: 0
    }
}
