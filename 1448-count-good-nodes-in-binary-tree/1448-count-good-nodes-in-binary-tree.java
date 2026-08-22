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
    public int goodNodes(TreeNode root) {
        return solve(root,Integer.MIN_VALUE);
    }
    public int solve(TreeNode root,int max){
        if(root==null) return 0;

        int currAns=0;

        if(max<=root.val)
        currAns=1;

        max=Math.max(max,root.val);

        int leftAns= solve(root.left,max);
        int rightAns= solve(root.right,max);
        return leftAns+rightAns+currAns;
    }
}
