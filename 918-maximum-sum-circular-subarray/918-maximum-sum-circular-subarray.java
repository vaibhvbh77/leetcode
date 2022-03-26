class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int i=0;
        int sum=0;
        while(i<nums.length){
            sum+=nums[i];
            i++;
        }
        // System.out.println(maxk(nums));
        // System.out.println(mink(nums));
        if(maxk(nums)<0)
            return maxk(nums);
        else
        return Math.max(maxk(nums),sum-mink(nums));
        
    }
     public int maxk(int[] nums) {
         int res=nums[0];
         int sum=nums[0];
         for(int i=1;i<nums.length;i++){
             sum=Math.max(nums[i],nums[i]+sum);
             res=Math.max(res,sum);
         }
         return res;
         
        
    }
     public int mink(int[] nums) {
         int res=nums[0];
         int sum=nums[0];
         for(int i=1;i<nums.length;i++){
             sum=Math.min(nums[i],nums[i]+sum);
             res=Math.min(res,sum);
         }
         return res;
         
        
    }
}