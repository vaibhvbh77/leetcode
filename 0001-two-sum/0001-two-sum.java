class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int size=nums.length;

        for(int index=0;index<size;index++){
            int complement=target-nums[index];
            boolean contains=map.containsKey(complement);
            // map contains that element
            if(contains){
                return new int[]{map.get(complement),index};
            }
            // did not find the element
            else{
                map.put(nums[index],index);
            }
        }
        return new int[]{-1,-1};
    }
}