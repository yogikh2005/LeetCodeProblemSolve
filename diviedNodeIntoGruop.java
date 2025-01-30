import java.util.*;

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        // Step 1: Build Graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[n + 1]; // 0: unvisited, 1 & -1 for bipartite check
        Arrays.fill(color, 0);
        List<List<Integer>> components = new ArrayList<>();
        
        // Step 2: Check for Bipartiteness and Extract Components
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) { // Unvisited node
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(graph, i, color, component)) return -1;
                components.add(component);
            }
        }

        // Step 3: Find Maximum Groups using BFS
        int maxGroups = 0;
        for (List<Integer> component : components) {
            maxGroups += getMaxBFSDepth(graph, component);
        }
        
        return maxGroups;
    }

    // BFS to check if the component is Bipartite
    private boolean isBipartite(List<List<Integer>> graph, int start, int[] color, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == 0) { // Unvisited
                    color[neighbor] = -color[node]; // Alternate color
                    queue.add(neighbor);
                    component.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // Found an odd cycle, graph is not bipartite
                }
            }
        }
        return true;
    }

    // BFS to find the maximum depth starting from any node
    private int getMaxBFSDepth(List<List<Integer>> graph, List<Integer> component) {
        int maxDepth = 0;
        for (int node : component) {
            maxDepth = Math.max(maxDepth, bfsDepth(graph, node));
        }
        return maxDepth;
    }

    // Run BFS to determine depth from a starting node
    private int bfsDepth(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return depth;
    }
}
