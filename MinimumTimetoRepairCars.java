class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) ranks[0] * (long) cars * cars;  // Upper bound
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRepairAllCars(ranks, cars, mid)) {
                answer = mid;  // Try to minimize the time
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long time) {
        long totalCarsRepaired = 0;
        for (int rank : ranks) {
            totalCarsRepaired += Math.sqrt(time / rank);
            if (totalCarsRepaired >= cars) return true;  // Early stopping
        }
        return totalCarsRepaired >= cars;
    }
}
