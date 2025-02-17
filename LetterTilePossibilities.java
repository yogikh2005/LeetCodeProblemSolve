import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numTilePossibilities(String tiles) {
        char[] tileArr = tiles.toCharArray();
        boolean[] used = new boolean[tiles.length()];
        Set<String> sequences = new HashSet<>();
        
        backtrack(tileArr, used, new StringBuilder(), sequences);
        return sequences.size();
    }
    
    private void backtrack(char[] tiles, boolean[] used, StringBuilder current, Set<String> sequences) {
        if (current.length() > 0) {
            sequences.add(current.toString());
        }
        
        for (int i = 0; i < tiles.length; i++) {
            if (used[i]) continue;
            
            used[i] = true;
            current.append(tiles[i]);
            backtrack(tiles, used, current, sequences);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
} /* You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1
 

Constraints:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.*/
