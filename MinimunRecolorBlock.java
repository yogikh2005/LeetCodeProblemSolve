class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOps = Integer.MAX_VALUE;
        int whiteCount = 0;

        // Count 'W' in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        minOps = whiteCount; // Initial window count

        // Slide the window through the string
        for (int i = k; i < blocks.length(); i++) {
            // Remove the leftmost character from the count
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            // Add the rightmost character to the count
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            // Update the minimum operations needed
            minOps = Math.min(minOps, whiteCount);
        }

        return minOps;
    }
}
