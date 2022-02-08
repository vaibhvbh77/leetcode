class Solution {
    public int addDigits(int num) {
        int res=0;
        
        while(num!=0){
            int ld=num%10;
            res+=ld;
            num=num/10;
            if(num==0&&res>9){
                num=res;
                res=0;
            }
        }
        
        return res;
        
    }
}