class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            //j and k 
            int j=i+1;
            int k=nums.length-1;
            int target=-nums[i];
            while(j<k){
                int sum=nums[j]+nums[k];
                if((sum==target &&(i==0||nums[i]!=nums[i-1]))){
                    ArrayList<Integer>list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                    while(j<nums.length&&nums[j]==nums[j-1]){
                        j++;
                    }
                     while(k>0&&nums[k]==nums[k+1]){
                        k--;
                    }
                }
                else if(sum>target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }

        return ans;

    }
}