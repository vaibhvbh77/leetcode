/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        solve(root);
        return max;
    }
    public int solve(TreeNode root){
        if(root==null) return 0;

        int left=Math.max(0,solve(root.left));
        int right=Math.max(0,solve(root.right));

        int currentPath=left+right+root.val;

        max=Math.max(currentPath,max);

        return root.val+Math.max(left,right);

    }
}