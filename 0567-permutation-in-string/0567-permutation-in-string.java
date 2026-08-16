class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // for(int i=0;i<=s2.length()-s1.length();i++){
        //     String substring=s2.substring(i,i+s1.length());
        //     if(isPermutation(s1,substring))
        //     return true;
        // }
        // return false;

        // Optimal
        if(s2.length()<s1.length()) return false;
            int []freq=new int[26];
            for(int i=0;i<s1.length();i++){
               freq[s1.charAt(i) - 'a']++;
               freq[s2.charAt(i) - 'a']--;
            }
            if(isZero(freq)) return true;

            // first window is calculated now next will be calculated from 
            // rem prev and adding new 
            for(int i=s1.length();i<s2.length();i++){
                // entered
                freq[s2.charAt(i)-'a']--;
                // removed
                freq[(s2.charAt(i - s1.length()))-'a']++;
                if(isZero(freq)){
                    return true;
                }

            }
            return false;



    }

    public boolean isZero(int []freq){
          boolean flag=true;
                for(int j=0;j<26;j++){
                    if(freq[j]!=0)
                    {
                        flag=false;
                    }
                }
                if(flag) return true;
                return false;

    }
    // public boolean isPermutation(String s1,String s2){
    //     int []freq=new int[26];
    //     for(int i=0;i<s1.length();i++){
    //         freq[s1.charAt(i)-'a']++;
    //         freq[s2.charAt(i)-'a']--;
    //     }

    //     for(int i=0;i<26;i++){
    //         if(freq[i]>0)
    //         return false;
    //     }
    //     return true;
    // }
}
