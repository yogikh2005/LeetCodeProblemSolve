import java.util.*;

class Solution {
    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        int left = 0, vowelCount = 0, consonantCount = 0;
        long result = 0;
        Map<Character, Integer> vowelMap = new HashMap<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);

            // If c is a vowel, track its count
            if (vowels.contains(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
                if (vowelMap.get(c) == 1) vowelCount++;  // New unique vowel found
            } else {
                consonantCount++;  // Count consonants
            }

            // Shrink the window if we have too many consonants
            while (consonantCount > k) {
                char leftChar = word.charAt(left);
                if (vowels.contains(leftChar)) {
                    vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                    if (vowelMap.get(leftChar) == 0) vowelCount--;  // Lost a unique vowel
                } else {
                    consonantCount--;  // Reduce consonant count
                }
                left++;  // Move left pointer
            }

            // If all vowels are present and consonant count == k, count this valid substring
            if (vowelCount == 5 && consonantCount == k) {
                result++;
            }
        }

        return result;
    }
}
