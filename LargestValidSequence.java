class Solution {
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] result = new int[len];
        boolean[] used = new boolean[n + 1];
        
        backtrack(result, used, 0, n);
        return result;
    }
    
    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        if (index == result.length) {
            return true;
        }
        
        if (result[index] != 0) {
            return backtrack(result, used, index + 1, n);
        }
        
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            
            int secondIndex = (num == 1) ? index : index + num;
            if (secondIndex < result.length && result[secondIndex] == 0) {
                result[index] = num;
                if (num > 1) result[secondIndex] = num;
                used[num] = true;
                
                if (backtrack(result, used, index + 1, n)) {
                    return true;
                }
                
                result[index] = 0;
                if (num > 1) result[secondIndex] = 0;
                used[num] = false;
            }
        }
        
        return false;
    }
}

/*
Given an integer n, find a sequence that satisfies all of the following:

The integer 1 occurs once in the sequence.
Each integer between 2 and n occurs twice in the sequence.
For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.

Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.

A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.

 

Example 1:

Input: n = 3
Output: [3,1,2,3,2]
Explanation: [2,3,2,1,3] is also a valid sequence, but [3,1,2,3,2] is the lexicographically largest valid sequence.
Example 2:

Input: n = 5
Output: [5,3,1,4,3,5,2,4,2]
 

Constraints:

1 <= n <= 20*/
