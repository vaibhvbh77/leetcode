class Solution {
    public int maxArea(int[] height) {
   int i=0;
        int j=height.length-1;
        int res=0;
        
        while(i<j){
            int width=j-i;
            int h=Math.min(height[i],height[j]);
            int area=h*width;
            res=Math.max(area,res);
            if(height[i]>height[j])
                j--;
            else 
                i++;
            
            
        }
        return res;
        
    }
}