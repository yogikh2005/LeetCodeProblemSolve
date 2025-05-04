import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;

        for (int[] domino : dominoes) {
            // Normalize each domino to ensure order does not matter
            int key = domino[0] <= domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];

            // Add the current count of that domino to result before incrementing
            result += count.getOrDefault(key, 0);

            // Update the frequency count
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        return result;
    }
}
