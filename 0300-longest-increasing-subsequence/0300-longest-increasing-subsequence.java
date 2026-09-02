class Solution {
    int[][]dp;
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length+1][nums.length+1];
        for(int []i:dp)
        Arrays.fill(i,-1);

        return solve(nums,0,-1);
    }
    public int solve(int []nums,int index,int prevIndex){
        if(index>=nums.length){
            return 0;
        }

        int take=0;
        int notTake=0;
        if(prevIndex!=-1 && dp[index][prevIndex+1]!=-1){
            return dp[index][prevIndex+1];
        }

            if(prevIndex==-1 || nums[index]>nums[prevIndex]){
//         then two options with me take or not take
                take=1+solve(nums,index+1,index);

            }
                 notTake=solve(nums,index+1,prevIndex);

        dp[index][prevIndex+1]= Math.max(take,notTake);

        return dp[index][prevIndex+1];

    }
}