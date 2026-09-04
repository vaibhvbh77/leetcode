class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index1=g.length-1;
        int index2=s.length-1;
        int count=0;


        while(index1>=0 && index2>=0){
            if(g[index1]<=s[index2]){
                count++;
                index1--;
                index2--;
            }
            else{
                index1--;
            }
        }
        return count;

        
    }
}