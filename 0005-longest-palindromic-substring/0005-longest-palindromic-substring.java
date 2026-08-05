class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            //odd length
            int low=i;
            int high=i;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
            }
            if(ans.length()<high-low-1){
                ans=s.substring(low+1,high);
            }

            // even

             low=i;
             high=i+1;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
            }
            if(ans.length()<high-low-1){
                ans=s.substring(low+1,high);
            }

        }
        return ans;
        
    }
}