import java.util.*;

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {

        // Store friends in a HashSet for fast lookup
        Set<Integer> friendSet = new HashSet<>();
        for (int f : friends) {
            friendSet.add(f);
        }

        // List to store friends in finishing order
        List<Integer> result = new ArrayList<>();

        // Traverse the race finishing order
        for (int id : order) {
            if (friendSet.contains(id)) {
                result.add(id);
            }
        }

        // Convert list to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
