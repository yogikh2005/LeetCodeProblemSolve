class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int index = sb.indexOf(part);
        
        while (index != -1) {
            sb.delete(index, index + part.length());
            index = sb.indexOf(part);
        }
        
        return sb.toString();
    }
}
