class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []lp=new int[nums.length];
        lp[0]=1;
        int []arr=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            lp[i]=lp[i-1]*nums[i-1];
        }
        int suffix=1;
        for(int i=nums.length-1;i>=0;i--){
            arr[i]=suffix*lp[i];
            suffix=suffix*nums[i];
        }
        return arr;
    }
}