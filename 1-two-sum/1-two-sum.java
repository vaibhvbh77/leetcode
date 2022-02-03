class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>set=new HashMap<>();
        int []arr=new int[2];
        set.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(set.containsKey(target-nums[i]))
            {
                arr[0]=i;
                arr[1]=set.get(target-nums[i]);
                return arr;
            }
        else
            set.put(nums[i],i);
        
    }
    return arr;
    }
}