import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        // Count frequencies for each value
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Check if any frequency is prime
        for (int count : freq.values()) {
            if (isPrime(count)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check prime
    private boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
