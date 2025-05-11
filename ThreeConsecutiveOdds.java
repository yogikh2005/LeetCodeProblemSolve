public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // Counter to track consecutive odd numbers
        int count = 0;

        // Iterate through the array
        for (int num : arr) {
            // Check if the number is odd
            if (num % 2 != 0) {
                count++;
                // If three consecutive odds are found, return true
                if (count == 3) {
                    return true;
                }
            } else {
                // Reset the count if the number is even
                count = 0;
            }
        }

        // If loop ends without finding three consecutive odds
        return false;
    }

    // Test case demonstration (you can remove this before submission)
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.threeConsecutiveOdds(new int[]{2, 6, 4, 1})); // Output: false
        System.out.println(sol.threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12})); // Output: true
    }
}
