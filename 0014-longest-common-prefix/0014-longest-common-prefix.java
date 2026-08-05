class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans=strs[0];
        for(int i=1;i<strs.length;i++){
            int j;
            for(j=0;j<strs[i].length() && ans.length()>j;j++){
                if(strs[i].charAt(j)==ans.charAt(j)){
                    continue;
                }
                else{
                    break;
                }
            }
            ans=strs[i].substring(0,j);
        }
        return ans;
        
    }
}