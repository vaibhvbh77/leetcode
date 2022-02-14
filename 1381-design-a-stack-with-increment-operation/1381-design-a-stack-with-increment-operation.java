class CustomStack {

    int []arr;
    int top;
    
    public CustomStack(int maxSize) {
        arr=new int[maxSize];
        top=-1;
    }
    
    public void push(int x) {
        if(arr.length!=top+1){
            arr[++top]=x;
        }
    }
    
    public int pop() {
        if(top==-1)
            return -1;
        
        int res=arr[top];
        top--;

            return res;
        
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k&&i<arr.length;i++)
            arr[i]+=val;
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */