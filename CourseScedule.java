import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Create an adjacency matrix to represent the graph
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        // Step 2: Fill the adjacency matrix based on the given prerequisites
        for (int[] prerequisite : prerequisites) {
            isPrerequisite[prerequisite[0]][prerequisite[1]] = true;
        }

        // Step 3: Apply Floyd-Warshall algorithm to compute transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrerequisite[i][k] && isPrerequisite[k][j]) {
                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }

        // Step 4: Process queries and build the result
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrerequisite[query[0]][query[1]]);
        }

        return result;
    }
}
