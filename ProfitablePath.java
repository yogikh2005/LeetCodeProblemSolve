import java.util.*;

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // Step 1: Build adjacency list
        int n = amount.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        // Step 2: Find Bob's path to root (node 0)
        Map<Integer, Integer> bobPath = new HashMap<>();
        findBobPath(bob, -1, 0, tree, bobPath);

        // Step 3: Perform DFS for Alice to maximize profit
        return dfs(0, -1, 0, 0, tree, bobPath, amount);
    }

    // Find the path Bob takes to reach node 0
    private boolean findBobPath(int node, int parent, int depth, List<Integer>[] tree, Map<Integer, Integer> bobPath) {
        if (node == 0) {
            bobPath.put(node, depth);
            return true;
        }
        for (int neighbor : tree[node]) {
            if (neighbor != parent && findBobPath(neighbor, node, depth + 1, tree, bobPath)) {
                bobPath.put(node, depth);
                return true;
            }
        }
        return false;
    }

    // DFS to compute Alice's maximum profit
    private int dfs(int node, int parent, int time, int income, List<Integer>[] tree, Map<Integer, Integer> bobPath, int[] amount) {
        boolean isLeaf = true;
        
        // Calculate Alice's income at this node
        if (bobPath.containsKey(node)) {
            int bobTime = bobPath.get(node);
            if (bobTime == time) { // Both arrive at the same time
                income += amount[node] / 2;
            } else if (bobTime > time) { // Alice arrives first
                income += amount[node];
            }
            // If Bob arrives first, Alice gets nothing
        } else {
            income += amount[node];
        }

        int maxIncome = Integer.MIN_VALUE;
        for (int neighbor : tree[node]) {
            if (neighbor != parent) {
                isLeaf = false;
                maxIncome = Math.max(maxIncome, dfs(neighbor, node, time + 1, income, tree, bobPath, amount));
            }
        }

        // If it's a leaf node, return the income
        return isLeaf ? income : maxIncome;
    }
}
