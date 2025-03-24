import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Use a TreeSet to store all days that have meetings
        TreeSet<Integer> meetingDays = new TreeSet<>();
        
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            
            // Add all days in the range [start, end] to the set
            for (int d = start; d <= end; d++) {
                meetingDays.add(d);
            }
        }
        
        // Total available days minus days occupied by meetings
        return days - meetingDays.size();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] meetings1 = {{5, 7}, {1, 3}, {9, 10}};
        System.out.println(sol.countDays(10, meetings1)); // Output: 2

        int[][] meetings2 = {{2, 4}, {1, 3}};
        System.out.println(sol.countDays(5, meetings2)); // Output: 1

        int[][] meetings3 = {{1, 6}};
        System.out.println(sol.countDays(6, meetings3)); // Output: 0
    }
}
