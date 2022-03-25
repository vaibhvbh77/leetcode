class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int res=0;
        
        while(i<nums.length){
        int curr=0;
            while(i<nums.length&&nums[i]==1){
                curr++;
                i++;
            }
            res=Math.max(curr,res);
            i++;
        }
        return res;
        
    }
}