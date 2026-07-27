class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(int)Math.floor((low+high)/2);
            if(nums[mid]==target)return mid;
            //left half is sorted
            if(nums[mid]>=nums[low]){
                // is my element there or not
                if(target >= nums[low] && target < nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            // right half is sorted
            else{
                if(nums[mid]<=target &&target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
