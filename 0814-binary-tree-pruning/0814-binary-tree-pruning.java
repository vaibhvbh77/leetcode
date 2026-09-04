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
    public TreeNode pruneTree(TreeNode root) {
            solve(root);
        if(root!=null&&root.val == 0 && root.left == null && root.right == null) return null;

        return root;
    }
    public TreeNode solve(TreeNode root){
        if(root==null) return null;


        if(!containsOne(root.left)){
            root.left=null;
        }
          if(!containsOne(root.right)){
            root.right=null;
        }



        solve(root.left);
        solve(root.right);

        return root;



    }

    public boolean containsOne(TreeNode root){
        if(root==null) return false;
        if(root.val==1) return true;

        boolean left=containsOne(root.left);
        boolean right=containsOne(root.right);

        if(left || right) return true;

        return false;
    }
}