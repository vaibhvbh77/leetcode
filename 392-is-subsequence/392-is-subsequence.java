class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0&&t.length()!=0)
            return true; 
        if(s.length()==0)
            return true;
        
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            System.out.print(i);
            if(t.charAt(j)==s.charAt(i))
            {i++;j++;if(i==s.length())return true;}
            else
                j++;
            
            
        }
        
      return false;
        
    }
}