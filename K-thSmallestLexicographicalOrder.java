class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1; // Start with prefix 1
        k -= 1; // Because we already count '1' as the first number

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                // Move to next sibling
                current += 1;
                k -= steps;
            } else {
                // Move to next level (child prefix)
                current *= 10;
                k -= 1;
            }
        }

        return current;
    }

    // Count number of integers in range [n1, n2) with upper limit n
    private long countSteps(int n, long n1, long n2) {
        long steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
