class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String>li=new ArrayList<String>();
        
        int prev=0;
        int i=0;
        
        
        for(;i<nums.length&&prev<nums.length;){
            
            if(i+1<nums.length&&nums[i]+1==nums[i+1])
                i++;
            
            else{
                String ans="";
                
                if(prev==i)
                    {
                        ans+=nums[prev];
                    }
                    
//                 diff
                else{
                    ans+=nums[prev]+"->"+nums[i];
                }
                    
                li.add(ans);
                 prev=i+1;
                i++;
                
                
                
                
                
                
            }
            
            
            
            
        }
       
        
        
        
        
        
        return li;
        
    }
}