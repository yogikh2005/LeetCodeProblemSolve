class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int totalSubarrays = (i + 1) * (n - i);
            int oddSubarrays = (totalSubarrays + 1) / 2;
            result += arr[i] * oddSubarrays;
        }

        return result;
    }
}
