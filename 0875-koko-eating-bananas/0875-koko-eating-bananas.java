class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // finding the max
        int max=0;
        for(int i:piles){
            max=Math.max(i,max);
        }
        // running the seach
        int low=1;
        int high=max;
        int ans=0;
        while(low<=high){
            int middle=(low+high)/2;
            if(isValid(middle,piles,h)){
                ans=middle;
                high=middle-1;
            }
            else{
                low=middle+1;
            }

        }
        return ans;


    }
    public boolean isValid(int speed,int []piles,int hour){
        long totalHours=0;
        for(int i=0;i<piles.length;i++)
        {
            totalHours=totalHours+(int)(Math.ceil((double)piles[i]/speed));
        }
        if(totalHours<=hour){
                return true;
            }
        return false;
    }
}