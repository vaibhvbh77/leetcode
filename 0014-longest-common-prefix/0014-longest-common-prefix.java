class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String ans=strs[0];
        int n=strs.length;
        String last=strs[n-1];
        int j;
            for(j=0;j<strs[n-1].length() && ans.length()>j;j++){
                if(last.charAt(j)==ans.charAt(j)){
                    continue;
                }
                else{
                    break;
                }
            }
            ans=last.substring(0,j);
        return ans;
        }
        
    }
