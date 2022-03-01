class Solution {
    public int[] countBits(int n) {
        int[]arr=new int[n+1];
        for(int i=0;i<=n;i++){
            fun(arr,i);
        }
        return arr;
    }
    public void fun(int []arr,int n){
        int res=0;
        int i=n;
        while(n!=0){
            n=n&(n-1);
            res++;
            
        }
        arr[i]=res;
        
    }
}