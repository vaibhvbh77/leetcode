class Solution {
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int i=0;i<nums.length;i++)
        total+=nums[i];

        if(total<Math.abs(target))return 0;    
        int subset=(total+target)/2;
        if ((total + target) % 2 != 0)return 0;
        dp=new int[nums.length+1][subset+1];

        for(int i = 0; i <= nums.length; i++){
            Arrays.fill(dp[i], -1);
            }

        return solve(nums,nums.length,subset);

    }

        public int solve(int [] arr,int index,int sum){
      if(index == 1){

    if(sum == 0 && arr[0] == 0)
        return 2;

    if(sum == 0 || sum == arr[0])
        return 1;

    return 0;
}
        
        if(dp[index][sum] != -1)
            return dp[index][sum];
    
        if(sum>=arr[index-1]){
            int take=solve(arr,index-1,sum-arr[index-1]);
            int skip=solve(arr,index-1,sum);
            dp[index][sum]=take+skip;
            return dp[index][sum];
        }
        int skip=solve(arr,index-1,sum);
        dp[index][sum]=skip;
        return dp[index][sum];
    }

}
