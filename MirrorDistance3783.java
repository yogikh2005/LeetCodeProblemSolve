class Solution {
    public int mirrorDistance(int n) {
        int rev = 0;
        int temp = n;

        while (temp > 0) {
            int d = temp % 10;
            rev = (rev * 10) + d;
            temp /= 10;
        }

        return Math.abs(n - rev);
    }
}
