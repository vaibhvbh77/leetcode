class Solution {
    public int majorityElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int count=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==nums[i])
                count++;
            }
        if(count>nums.length/2)
            return nums[i];
        }
        return -1;
    }
}