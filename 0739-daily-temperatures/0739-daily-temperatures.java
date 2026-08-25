class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>st=new Stack<Integer>();
        int n=temperatures.length;
        int []ans=new int[n];
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty()&& temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]=st.peek()-i;
            }
            st.push(i);

            }
        return ans;
        }


}