class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=Integer.MIN_VALUE;
        solve(root);
        return max;
    }

    public void solve(TreeNode root){
        if(root==null) return ;

        int left=height(root.left);
        int right=height(root.right);

        max=Math.max(max,left+right);
        solve(root.left);
        solve(root.right);

    }


    public int height(TreeNode root){
        if(root==null)
        return 0;

        int left=height(root.left);
        int right=height(root.right);

        return Math.max(left,right)+1;
    }
}