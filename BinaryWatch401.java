class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        
	    List<String> res=new ArrayList<>();
	    for (int h=0;h<12;h++)
	    {
	        for(int m=0;m<60;m++)
	        {
	            int bit=Integer.bitCount(h)+Integer.bitCount(m);
	            if(bit==turnedOn)
	            {
	                res.add(h+":"+String.format("%02d",m));
	            }
	        }
	    }
	    
	    return res;
    }
}
