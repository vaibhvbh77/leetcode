class Solution {
    
    //finding the number whichcan be swap i.e., it should be present at each index either tops or bottom
    private int check(int[] tops,int[] bottoms,int elem){
        
        for(int i=0;i<tops.length;i++){
            if(tops[i] != elem && bottoms[i] != elem){
                return -1;
            } 
        }
        return elem;
        
    }
    
    //finding the min swap 
    private int findMinSwap(int[] tops,int[] bottoms,int elem){
        int ans1 = 0;
        int ans2 = 0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]==elem && bottoms[i] == elem) continue;
            if(tops[i] != elem)
                ans1++;
            else
                ans2++;
        }
        
        return Math.min(ans1,ans2);
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        //check which number can be swapped tops[0] or bottom[0]
        if(check(tops,bottoms,tops[0])!=-1)
                return findMinSwap(tops,bottoms,tops[0]);
        if(check(tops,bottoms,bottoms[0])!=-1)
                return findMinSwap(tops,bottoms,bottoms[0]);

        return -1;
        
        
    }
}

