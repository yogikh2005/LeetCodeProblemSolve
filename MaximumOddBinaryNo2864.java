class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        
        // Count number of '1's
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        
        // One '1' must be at the end
        ones--; 
        
        StringBuilder result = new StringBuilder();
        
        // Place remaining '1's at the beginning
        for (int i = 0; i < ones; i++) {
            result.append('1');
        }
        
        // Fill remaining positions with '0's
        int zeros = s.length() - ones - 1;
        for (int i = 0; i < zeros; i++) {
            result.append('0');
        }
        
        // Place the last '1' to make the number odd
        result.append('1');
        
        return result.toString();
    }
}
