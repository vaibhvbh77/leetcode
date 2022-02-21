class Solution {
    public int majorityElement(int[] nums) {

            int count=1;
        int c=nums[0];
            for(int j=1;j<nums.length;j++){
                if(count==0)
                    c=nums[j];
                if(nums[j]==c)
                    count++;
                else
                    count--;
               
            }
        if(count>0)
            return c;

        
        return -1;
    }
}