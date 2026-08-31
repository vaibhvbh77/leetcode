class Solution {
    HashSet<String> set;
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dp=new Boolean[s.length()+1];
        return solve(s, wordDict, 0);
    }

    public boolean solve(String s, List<String> dict, int index) {
        if (index >= s.length())
            return true;

        if (dp[index] != null)
            return dp[index];
        for (int i = index; i < s.length(); i++) {
            if (set.contains(s.substring(index, i + 1))) {
                boolean ans = solve(s, dict, i + 1);
                if (ans) {
                    dp[index] = true;
                    return true;
                }
            }

        }
        dp[index] = false;
        return false;
    }
}