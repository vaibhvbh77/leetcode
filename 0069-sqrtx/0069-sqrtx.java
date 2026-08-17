class Solution {
    public int mySqrt(int x) {
        if(x==0 ||x==1) return x;

        int low=1;
        int high=x;
        int ans=0;

        while(low<=high){
            int middle=low+(high-low)/2;
            if(middle*middle==x)
            return middle;

            if((long)middle*middle>x){
                high=middle-1;
            }
            else 
            {
                   ans = middle;
                 low=middle+1;}

        }

        return ans;

    }
}