class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (String s : sentences) {
            int spaces = 0;
            for (char ch : s.toCharArray()) {
                if (ch == ' ') spaces++;
            }
            maxWords = Math.max(maxWords, spaces + 1);
        }

        return maxWords;
    }
}
