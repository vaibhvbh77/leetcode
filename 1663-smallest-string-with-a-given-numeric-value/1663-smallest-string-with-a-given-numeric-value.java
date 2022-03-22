class Solution {
    public String getSmallestString(int n, int k) {
        char []arr=new char[n];
        int i=0;
        while(i<n)
            arr[i++]='a';
        int j=n-1;
        k=k-n;
        
        while(k>0){
            if(k>25){
                arr[j]='z';
                k=k-25;
                
            }
            else
            {
                arr[j]=(char) ('a'+k);
                k=0;
            }
            
            
            j--;
        }
        return new String(arr);
        
    }
}