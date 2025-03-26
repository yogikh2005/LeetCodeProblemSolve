import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        
        // Flatten the grid into a list
        for (int[] row : grid) {
            for (int num : row) {
                nums.add(num);
            }
        }
        
        // Check if transformation is possible
        int remainder = nums.get(0) % x;
        for (int num : nums) {
            if (num % x != remainder) {
                return -1; // Impossible case
            }
        }
        
        // Sort the list to find the median efficiently
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        
        // Calculate the minimum number of operations
        int operations = 0;
        for (int num : nums) {
            operations += Math.abs(num - median) / x;
        }
        
        return operations;
    }
}
import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        
        // Flatten the grid into a list
        for (int[] row : grid) {
            for (int num : row) {
                nums.add(num);
            }
        }
        
        // Check if transformation is possible
        int remainder = nums.get(0) % x;
        for (int num : nums) {
            if (num % x != remainder) {
                return -1; // Impossible case
            }
        }
        
        // Sort the list to find the median efficiently
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        
        // Calculate the minimum number of operations
        int operations = 0;
        for (int num : nums) {
            operations += Math.abs(num - median) / x;
        }
        
        return operations;
    }
}
