class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;

        // Check all k-length subarrays including circular cases
        for (int i = 0; i < n; i++) {
            if (isAlternating(colors, i, k, n)) {
                count++;
            }
        }

        return count;
    }

    private boolean isAlternating(int[] colors, int start, int k, int n) {
        for (int i = 1; i < k; i++) {
            int prev = colors[(start + i - 1) % n];
            int curr = colors[(start + i) % n];

            if (prev == curr) return false; // Not alternating
        }
        return true;
    }
}
