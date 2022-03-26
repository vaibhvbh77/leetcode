class Solution {
    public int search(int[] nums, int target) {
        // if(nums.length==1){
        //     if(target==nums[0])
        //         return 0;
        //     else
        //         return -1;
        // }
        
        
        
        int i=0;;
        int j=nums.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                j--;
            else
                i++;
        }
        return -1;
        
    }
}