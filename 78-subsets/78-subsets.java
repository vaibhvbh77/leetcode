class Solution {
    List<List<Integer>>res=new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        set(new ArrayList<Integer> (),nums,0);
        return res;
        
    }
    public void set(List<Integer>list,int []nums,int i){
        if(i==nums.length){
            res.add(new ArrayList<Integer>(list));
            return ;
            
           }

        int val=nums[i];
        list.add(val);
        set(list,nums,i+1);
        list.remove(list.size()-1);
        set( list,nums,i+1);
        
    }
}