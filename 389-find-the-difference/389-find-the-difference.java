class Solution {
    public char findTheDifference(String s, String t) {
      HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);       
        }
        for(int i=0;i<s.length();i++){
            int se=map.get(s.charAt(i));
            if(map.containsKey(s.charAt(i))&&se==1){
                map.remove(s.charAt(i));
            }
            else{
                map.replace(s.charAt(i),map.get(s.charAt(i))-1);
            }
        }char ans='a';
            for(char x:map.keySet()){
                ans=x;
        }
        
        
        return ans;
        
        
        
    }
}
