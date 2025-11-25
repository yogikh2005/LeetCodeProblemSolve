class Solution {
    public int smallestRepunitDivByK(int k) {
       
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int rem = 1 % k;
        int length = 1;

        while (rem != 0 && length <= k) {
            rem = (rem * 10 + 1) % k;
            length++;
        }

        return rem == 0 ? length : -1;
    }
}
