class Solution {
    int [][]memo;
    int offset;
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int i:nums)
        total+=i;

        memo=new int[nums.length][2*total+1];

        for(int []i:memo)
        Arrays.fill(i,-1);

        offset=total;

        return solve(nums,0,0,target);
        // range -total to total
        // 0 to 2*total
    }
    public int solve(int []nums,int index,int sum,int target){
        
        if(index==nums.length) {
            if(target==sum) return 1;
            return 0;
        }

        int column=sum+offset;

        if(memo[index][column]!=-1) return memo[index][column];
        // choice 1: put + before the current numner 
        int add=solve(nums,index+1,sum+nums[index],target);


        // choice 2: put - before the current numner 
        int subtract=solve(nums,index+1,sum-nums[index],target);

        memo[index][column]= add+subtract;

        return memo[index][column];


    }
}