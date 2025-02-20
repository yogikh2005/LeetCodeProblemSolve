import java.util.HashSet;
import java.util.Set;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        
        // Generate all possible binary strings of length n
        for (int i = 0; i < (1 << n); i++) {
            String binary = Integer.toBinaryString(i);
            // Pad with leading zeros to match length n
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            if (!set.contains(binary)) {
                return binary;
            }
        }
        return ""; // This line will never be reached
    }
}
