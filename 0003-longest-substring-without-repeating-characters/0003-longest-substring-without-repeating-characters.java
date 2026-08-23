class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int low=0;
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<s.length();i++){
        //  this will run if set dont contains that element
                if(!set.contains(s.charAt(i))){
                    set.add(s.charAt(i));
                }
                else{
                    // duplicated element:
                    while(set.contains(s.charAt(i))){
                        set.remove(s.charAt(low));
                        low++;
                    }
                    set.add(s.charAt(i));
                }
                ans=Math.max(set.size(),ans);


        }

        return ans;
    }
}