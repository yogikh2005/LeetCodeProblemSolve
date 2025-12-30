class Solution {
    public int maxDistinct(String s) {
        boolean[] used = new boolean[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (!used[idx]) {
                used[idx] = true;
                count++;
            }
        }
        return count;
    }
}
