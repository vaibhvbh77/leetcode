class Solution {
    public int maxArea(int[] heights) {
        int res=Integer.MIN_VALUE;
        int low=0;
        int high=heights.length-1;
        while(low<high){
            int width=high-low;
            int height=Math.min(heights[low],heights[high]);
            int area=width*height;
            res=Math.max(area,res);
            if(heights[low]<heights[high]){
                low++;
            }
            else{
                high--;
            }
        }
        return res;
    }
}
