class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // DP array to store max points from each index onwards
        
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            
            // If we solve this question, the next available question is i + brainpower + 1
            int nextQuestion = i + brainpower + 1;
            long solve = points + (nextQuestion < n ? dp[nextQuestion] : 0);
            
            // If we skip this question, take the max points from the next question
            long skip = dp[i + 1];
            
            // Store the max result in dp[i]
            dp[i] = Math.max(solve, skip);
        }
        
        return dp[0]; // The max points that can be earned starting from index 0
    }
}
