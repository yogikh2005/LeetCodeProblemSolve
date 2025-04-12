import java.util.*;

public class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<Map<Character, Integer>> validPatterns = new HashSet<>();

        int start = (int)Math.pow(10, n - 1);
        int end = (int)Math.pow(10, n);

        // Step 1 & 2: Generate palindromes and check divisibility
        for (int i = start; i < end; i++) {
            String s = Integer.toString(i);
            if (isPalindrome(s) && i % k == 0) {
                Map<Character, Integer> freq = getDigitCount(s);
                validPatterns.add(freq);
            }
        }

        // Step 3: Count permutations matching any valid pattern
        long count = 0;
        for (int i = start; i < end; i++) {
            String s = Integer.toString(i);
            Map<Character, Integer> freq = getDigitCount(s);
            if (validPatterns.contains(freq)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    private Map<Character, Integer> getDigitCount(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
