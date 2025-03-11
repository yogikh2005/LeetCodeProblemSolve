class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3]; // To track occurrences of 'a', 'b', and 'c'
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++; // Increment the count of current character

            // Ensure the window contains at least one of each character
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += s.length() - right; // Count substrings starting from left
                count[s.charAt(left) - 'a']--; // Shrink window from the left
                left++;
            }
        }

        return result;
    }
}
