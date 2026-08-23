class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
        HashSet<Character>set=new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                }
                else{
                    break;
                }
                ans=Math.max(set.size(),ans);
        }

        }

        return ans;
    }
}