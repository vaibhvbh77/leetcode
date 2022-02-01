class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int l=nums[0];
        for(int i=1;i<nums.length;i++){
            max=Math.max(max+nums[i],nums[i]);
            l=Math.max(l,max);
        }
        return l;
    }
}