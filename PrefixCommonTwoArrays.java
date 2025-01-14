/*
You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
*/
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        Set<Integer> seenA = new HashSet<>();
        Set<Integer> seenB = new HashSet<>();
        
        int commonCount = 0;
        
        for (int i = 0; i < n; i++) {
            seenA.add(A[i]);
            seenB.add(B[i]);
            
            if (seenA.contains(B[i])) {
                commonCount++;
            }
            if (seenB.contains(A[i]) && A[i] != B[i]) {
                commonCount++;
            }
            
            result[i] = commonCount;
        }
        
        return result;
    }
}
