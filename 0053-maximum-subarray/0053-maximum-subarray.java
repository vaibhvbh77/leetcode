class Solution {
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int currWindow=nums[0];
        for(int i=1;i<nums.length;i++){
            currWindow=Math.max(currWindow+nums[i],nums[i]);
            ans=Math.max(currWindow,ans);

        }
        return ans;
    }
}