class Solution {
    public int maxSubArray(int[] nums) {
        
//         kadens
        int max=nums[0];
        int loc=nums[0];
        
        
        for(int i=1;i<nums.length;i++){
            loc=Math.max(nums[i],loc+nums[i]);
            max=Math.max(loc,max);
            // System.out.println("local is "+loc+"  global is "+max);
            
        }
        return max;
        
        
    }
}