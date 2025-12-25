class Solution {
    public String convertDateToBinary(String date) {
        
        String[] parts = date.split("-");
        
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        String binaryYear = Integer.toBinaryString(year);
        String binaryMonth = Integer.toBinaryString(month);
        String binaryDay = Integer.toBinaryString(day);
        
        return binaryYear + "-" + binaryMonth + "-" + binaryDay;
    }
}
