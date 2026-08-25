class Solution {
    public int missingMultiple(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int i=1;
        int temp=k;
        while(set.contains(temp*i)){
            i++;
        }
        return temp*i;
        
    }
}