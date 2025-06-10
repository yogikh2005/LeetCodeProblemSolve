import java.util.*;

class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26]; // Frequency array for 'a' to 'z'

        // Count the frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int f : freq) {
            if (f > 0) {
                if (f % 2 == 1) {
                    maxOdd = Math.max(maxOdd, f);
                } else {
                    minEven = Math.min(minEven, f);
                }
            }
        }

        // Since constraints ensure there's at least one odd and one even frequency
        return maxOdd - minEven;
    }
}
