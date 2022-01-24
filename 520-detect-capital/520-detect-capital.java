class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==0)
            return true;
        
//         small
        if((int)word.charAt(word.length()-1)>90)
        {
            for(int i=0;i<word.length();i++)
                if(word.charAt(i)<91&&i!=0)
                    return false;
            
        }
//         capital
        else{
            for(int i=0;i<word.length();i++)
                if(word.charAt(i)>90)
                    return false;
            
        }
        return true;
        
    }
}