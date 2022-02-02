class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer>list=new ArrayList<Integer>();
        
        if(p.length()>s.length())
            return list;
        
        int []arr=frequency(p);
        int []arr2=frequency(s.substring(0,p.length()));
        if(isSame(arr,arr2))
            list.add(0);
        
        for(int i=p.length();i<s.length();i++){
            arr2[s.charAt((i-p.length()))-'a']--;
            arr2[s.charAt(i)-'a']++;
            if(isSame(arr,arr2))
                          list.add(i-p.length()+1);
            
        }
        
  
        
              return list;
        
        
    }
    
    
    public int[] frequency(String s){
        int []arr=new int[26];
        for(int i=0;i<s.length();i++)
            arr[s.charAt(i)-'a']++;
        
        return arr;
    }
    public boolean isSame(int []a,int b[]){
        for(int i=0;i<26;i++)
            if(a[i]!=b[i])
                return false;
        return true;
    }
}