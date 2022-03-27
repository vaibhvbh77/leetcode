class Solution {
    public int pivotIndex(int[] nums) {
        int[]ps=new int[nums.length];
        int[]ss=new int[nums.length];int s=0;int p=0;
        for(int i=0;i<nums.length;i++)
        {p+=nums[i];ps[i]=p;}
        
        for(int i=nums.length-1;i>=0;i--)
        {s+=nums[i];ss[i]=s;}
        
        for(int i=0;i<nums.length;i++)
            if(ps[i]==ss[i])
                return i;
        
        return -1;
            
        
    }
}