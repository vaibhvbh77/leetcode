class Solution {
    public boolean isPalindrome(int x) {
        String s=x+"";
        return is(x+"",0,s.length());
        
    }
     public boolean is(String s,int i,int n) {
         if(i>=n/2)
             return true;
         return (s.charAt(i)==s.charAt(n-i-1)&&
             is(s,i+1,n));
        
        
    }
}