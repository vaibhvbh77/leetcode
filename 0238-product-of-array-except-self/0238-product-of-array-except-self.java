class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []prefix=new int[nums.length];
        int []suffix=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0)
            {prefix[i]=1;continue;}

            prefix[i]=prefix[i-1]*nums[i-1];
        }
          for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1)
            {suffix[i]=1;continue;}

            suffix[i]=suffix[i+1]*nums[i+1];
        }

        int []ans=new int[nums.length];
        for(int i=0;i<ans.length;i++)
            {
                ans[i]=prefix[i]*suffix[i];
            }
            return ans;



    }
}