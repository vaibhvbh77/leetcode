class Solution {
    public void sortColors(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int middle=0;
        while(middle<=end){
            if(nums[middle]==0){
                int temp=nums[middle];
                nums[middle]=nums[start];
                nums[start]=temp;

                middle++;
                start++;
            }
            else if(nums[middle]==1){
                middle++;
            }
            else{
                int temp=nums[end];
                nums[end]=nums[middle];
                nums[middle]=temp;
                end--;
            }
        }
        
    }
}