class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int max0=Integer.MIN_VALUE;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;

        for(int i=0;i<triplets.length;i++){
            // 
            int []temp=triplets[i];
            if(temp[0]>target[0] || temp[1]>target[1]||temp[2]>target[2])
            continue;

            max0=Math.max(temp[0],max0);
            max1=Math.max(temp[1],max1);
            max2=Math.max(temp[2],max2);
        }

        return max0==target[0]&&max1==target[1]&&max2==target[2];
    }
}
