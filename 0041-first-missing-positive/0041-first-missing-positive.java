class Solution {
    public int firstMissingPositive(int[] nums) {
    //    Your intuition in notes
    //     First loop: Put every valid positive number x at its correct index x - 1.
    //     Second loop: Check whether nums[i] == i + 1. The first mismatch means i + 1 is the missing positive.
    //     One more thing: numbers <= 0 and numbers > n can be ignored, because they can never be the answer when the answer is within 1...n+1.
    int i=0;

    while(i<nums.length){
       if(nums[i] <= 0 ||
   nums[i] > nums.length ||
   nums[i] == i + 1 ||            nums[i] == nums[nums[i] - 1]) {

    i++;
}
        else{
            int correctIndex = nums[i] - 1;
            int temp=nums[i];
            nums[i]=nums[correctIndex];
            nums[correctIndex]=temp;
        }
    }

    for(int j=0;j<nums.length;j++){
        if(nums[j]!=j+1){
            return j+1;
        }
    }
 return nums.length + 1;

    }
}