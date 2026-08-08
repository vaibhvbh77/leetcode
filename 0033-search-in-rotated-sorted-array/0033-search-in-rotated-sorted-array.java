class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int middle=low+(high-low)/2;
            if(nums[middle]==target)return middle;
            // left half sorted
            if(nums[low]<=nums[middle]){
                if(target>=nums[low]&& target<nums[middle]){
                    high=middle-1;
                }
                else{
                 low=middle+1;   
                }

            }
            // right half is sorted
            else{
                if(target<=nums[high]&& target>nums[middle]){
                 low=middle+1;   
                }
                else{
                    high=middle-1;
                }

            }

        }
        return -1;
        
    }
}