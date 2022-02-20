class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {
            if (a[0] == b[0]) {
                return a[1]>b[1]?-1:1; 
            } else {
                return a[0]<b[0]?-1:1; 
            }
        });
        int previousStart = -1, previousEnd = -1, result = 0;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start > previousStart && end > previousEnd) {
                // __________
                //     _______
                previousStart = start;
                previousEnd = end;
                result++;
            }
        }
        return result;
    }
}