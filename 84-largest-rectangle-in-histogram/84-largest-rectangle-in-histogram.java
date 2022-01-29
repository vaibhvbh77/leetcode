class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        int []ps=new int[n];
        int []ns=new int[n];
//         previous smallest
        for(int i=0;i<n;i++){
            while(st.isEmpty()==false&&arr[i]<=arr[st.peek()]){
                
                st.pop();
            }
            if(st.isEmpty()==true){
                ps[i]=0;
                
            }
            else{
                ps[i]=st.peek()+1;
            }
            st.push(i);
            
            
            
            
        }
        while(st.isEmpty()==false){st.pop();}
        
        for(int i=n-1;i>=0;i--){
            while(st.isEmpty()==false&&arr[i]<=arr[st.peek()]){
                
                st.pop();
            }
            if(st.isEmpty()==true){
                ns[i]=n-1;
                
            }
            else{
                ns[i]=st.peek()-1;
            }
            st.push(i);
            
            
            
        }
        int max=0;
        for(int i=0;i<n;i++){
            int res=0;
            res=arr[i]*(ns[i]-ps[i]+1);
            max=Math.max(res,max);
            
        }
        return max;
        
        
        
    }
}