class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character>st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
//             ending char
            if(isEnd(s.charAt(i))){
                if(st.isEmpty())
                    return false;
                else{
                    char x=st.pop();
                    if(!isMatch(s.charAt(i),x))
                        return false;
                }
                
            }
            
//             starting char
            else
                st.push(s.charAt(i));

            
        }
        return st.isEmpty();
     
    }
    public boolean isEnd(char x){
        if(x=='}'||x==']'||x==')')
            return true;
        
        return false;
        
    }
     public boolean isMatch(char x,char y){
        if(x=='}'&&y=='{')
            return true;
        if(x==']'&&y=='[')
            return true;
        if(x==')'&&y=='(')
            return true;
         
        return false;
        
    }
}