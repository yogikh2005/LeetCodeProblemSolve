import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        int start = 0;

        while (start < nums.length) {
            Set<Integer> seen = new HashSet<>();
            boolean allDistinct = true;
            for (int i = start; i < nums.length; i++) {
                if (seen.contains(nums[i])) {
                    allDistinct = false;
                    break;
                }
                seen.add(nums[i]);
            }

            if (allDistinct) {
                return operations;
            }

            start += 3;
            operations++;
        }

        return operations;
    }
}
