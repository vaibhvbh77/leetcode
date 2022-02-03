class Solution {
    public int titleToNumber(String columnTitle) {
        HashMap<Character,Integer>map=new HashMap<>();
        char x='A';
        for(int i=1;i<=26;i++)
            map.put(x++,i);
        int res=0;
        int p=0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            
            res+=Math.pow(26,p)*map.get(columnTitle.charAt(i));
            p++;
            
        }
        return res;
      
        
        
    }
}