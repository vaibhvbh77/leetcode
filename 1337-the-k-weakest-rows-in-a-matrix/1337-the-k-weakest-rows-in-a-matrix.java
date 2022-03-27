class Solution {
    List<Integer> fr = new ArrayList<>();
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0 ; j < mat[i].length; j++){
                if(mat[i][j] == 1) count++;
            }
            fr.add(count);
        }
        for(int i = 0; i < k; i++)
            ans[i] = calmin();
        return ans;
    }
    int calmin(){
        int min = fr.get(0);
        int ind = 0;
        for(int i = 0; i < fr.size(); i++){
            if(min > fr.get(i)){
                min = fr.get(i);
                ind = i;
            }
        }
        fr.set(ind, Integer.MAX_VALUE);
        return ind;
    }
}