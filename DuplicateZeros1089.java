class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;

        // Step 1: Count zeros
        for (int num : arr) {
            if (num == 0) {
                zeros++;
            }
        }

        // Step 2: Backward traversal
        int i = n - 1;
        int j = n + zeros - 1;

        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }
            i--;
            j--;
        }
    }
}
