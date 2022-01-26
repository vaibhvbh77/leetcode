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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer>arr=new ArrayList<Integer>();
        dfs(root1,arr);
        dfs(root2,arr);
        Collections.sort(arr);
        return arr;
        
        
    }
    void dfs(TreeNode root1,ArrayList<Integer> arr){
        if(root1==null)
            return ;
        
        arr.add(root1.val);
        dfs(root1.left,arr);
        dfs(root1.right,arr);

        
    }
}