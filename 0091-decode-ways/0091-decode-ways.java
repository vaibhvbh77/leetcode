class Solution {
    int dp[];
    public int numDecodings(String s) {
        dp=new int [s.length()+1];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }
    public int solve(String s, int index){
        if(index>=s.length())
        return 1;

        if (s.charAt(index) == '0')
            return 0;

        if(dp[index]!=-1){
            return dp[index];
        }

        int total=0;
        total+=solve(s,index+1);


        if(index+1<s.length()){
        String sub=""+s.charAt(index)+s.charAt(index+1);
        int value=Integer.parseInt(sub);
        if(value<=26 &&value>=10){
            total+=solve(s,index+2);
        }
        }

        dp[index]= total;
        return total;

    }
}
