import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // Union-Find (Disjoint Set Union) class
        class UnionFind {
            int[] parent, rank;

            public UnionFind(int size) {
                parent = new int[size];
                rank = new int[size];
                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]); // Path compression
                }
                return parent[x];
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX != rootY) {
                    if (rank[rootX] > rank[rootY]) {
                        parent[rootY] = rootX;
                    } else if (rank[rootX] < rank[rootY]) {
                        parent[rootX] = rootY;
                    } else {
                        parent[rootY] = rootX;
                        rank[rootX]++;
                    }
                }
            }
        }

        // Initialize Union-Find
        UnionFind uf = new UnionFind(n);

        // Connect indices based on the |nums[i] - nums[j]| <= limit condition
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= limit) {
                    uf.union(i, j);
                }
            }
        }

        // Group indices by their connected components
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // Sort the values in each component and place them back
        int[] result = nums.clone();
        for (List<Integer> indices : components.values()) {
            List<Integer> values = new ArrayList<>();
            for (int index : indices) {
                values.add(nums[index]);
            }
            Collections.sort(values);
            Collections.sort(indices);
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = values.get(i);
            }
        }

        return result;
    }
}
