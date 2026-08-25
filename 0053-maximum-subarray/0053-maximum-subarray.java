class Solution {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int window=nums[0];
        for(int i=1;i<nums.length;i++){
            window=Math.max(nums[i],nums[i]+window);
            res=Math.max(res,window);

        }
        return res;
        
    }
}