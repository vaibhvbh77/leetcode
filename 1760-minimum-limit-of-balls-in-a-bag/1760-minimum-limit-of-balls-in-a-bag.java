class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max=0;
        int ans=0;
        for(int i:nums){
            max=Math.max(i,max);
        }
        int low=1;
        int high=max;
        while(low<=high){
             int middle=low+(high-low)/2;
            if(isValid(nums,maxOperations,middle)){
                ans=middle;
                high=middle-1;
            }
            else{
                low=middle+1;
            }
        }
        return ans;
        
    }
    public boolean isValid(int []nums,int max,int penalty){
        long totalOperations=0;
        for(int i=0;i<nums.length;i++){
            totalOperations=totalOperations+(int)Math.ceil((double)nums[i]/penalty)-1;
        }

        if(totalOperations<=max)
        return true;
        return false;
    }
}