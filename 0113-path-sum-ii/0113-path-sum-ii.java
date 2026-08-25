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
     List<List<Integer>>ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList<>();
        solve(root,targetSum,new ArrayList<Integer>(),0);

        return ans;

        
    }

    public void solve(TreeNode root,int targetSum,ArrayList<Integer>list,int sum){
        if(root==null) return ;
        list.add(root.val);
        sum=sum+root.val;
        if(root.left==null &&root.right==null && sum==targetSum){
            ans.add(new ArrayList<>(list));
        }
        solve(root.left,targetSum,list,sum);


        solve(root.right,targetSum,list,sum);
        
        list.remove(list.size()-1);
    }
}