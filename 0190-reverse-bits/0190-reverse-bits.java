class Solution {
    public int reverseBits(int n) {
        int ans=0;
        int count=1;
        while(count!=32){
            // pick the last bit
            count++;
            int lastBit=n&1;
            ans=ans|lastBit;
            ans=ans<<1;
            n=n>>1;
            // put it on the ans
            // shift it
        }
        return ans;
    }
}