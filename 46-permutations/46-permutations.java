class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        boolean []flag=new boolean[nums.length];
        List<Integer>list=new ArrayList<>();
        per(nums,flag,list,ans);
        return ans;
        
    }
    public void per(int nums[],boolean []flag,List<Integer>list,List<List<Integer>> ans){
        
//         base case
        if(list.size()==nums.length){
            ans.add(new ArrayList<Integer>(list));
            return ;
        }
        
        
        for(int i=0;i<nums.length;i++){
            if(flag[i]==false){
                flag[i]=true;
                list.add(nums[i]);
                per(nums,flag,list,ans);
                list.remove(list.size()-1);
                flag[i]=false;                
            }
        }
        
        
    }
}