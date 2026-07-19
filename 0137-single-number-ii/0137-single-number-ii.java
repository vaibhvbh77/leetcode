class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int numbers:nums){
                //agar ith  bit set hai to 
                if((numbers&1<<i)!=0){
                    count++;
                }
            }

            count=count%3;
            if(count==1){
                res=res|(1<<i);
            }
        }
        return res;
    }
}