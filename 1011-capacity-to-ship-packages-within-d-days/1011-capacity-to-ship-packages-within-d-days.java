class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int i:weights){
            high=high+i;
            low=Math.max(low,i);
        }
        int ans=low;
        while(low<=high){
            int middle=low+(high-low)/2;
            if(isValid(weights,days,middle)){
                ans=middle;
                high=middle-1;
            }
            else{
                low=middle+1;
            }
        }
        return ans;
    }
    public boolean isValid(int []weights,int days,int capacity){
        int Totaldays=1;
        int localCap=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+localCap<=capacity){
                localCap=localCap+weights[i];
            }
            else{
                Totaldays++;
                localCap=weights[i];
            }
        }
        if(days>=Totaldays)
        return true;
        else 
        return false;
    }
}