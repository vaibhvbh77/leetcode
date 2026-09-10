class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lb=0;
        int ub=0;
        int ans=Integer.MAX_VALUE;
        for(int i:weights){
            lb=Math.max(i,lb);
            ub=ub+i;
        }        

        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            int daysReq=canShip(weights,mid);
            if(daysReq<=days){
                ans=Math.min(mid,ans);
                ub=mid-1;
                
            }
            else if(daysReq>days){
                lb=mid+1;
            }

        }
        return ans;
    }

 public int canShip(int[] arr,int period) {
    int count = 1;
    int capacity = period;

    for (int i = 0; i < arr.length; i++) {

        if (arr[i] > capacity) {
            count++;
            capacity = period;
        }

        capacity = capacity - arr[i];
    }

    return count;
}
}