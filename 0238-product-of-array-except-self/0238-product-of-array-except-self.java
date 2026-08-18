class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] prefix=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0)
            {prefix[i]=1;continue;}

            prefix[i]=prefix[i-1]*nums[i-1];
        }
        int suffix=1;
          for(int i=nums.length-1;i>=0;i--){
            prefix[i]=suffix*prefix[i];
            suffix=suffix*nums[i];
        }


            return  prefix;



    }
}