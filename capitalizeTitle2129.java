class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (word.length() <= 2) {
                word = word.toLowerCase();
            } else {
                word = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            }
            
            if (i > 0) result.append(" ");
            result.append(word);
        }
        
        return result.toString();
    }
}
