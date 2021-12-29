/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        
        
        HashSet<Node> set=new HashSet<Node>();
        set=left(root,set);
        if(root==null)
            return root;
        Queue<Node>q=new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node x=q.poll();
            if(set.contains(x)){
                
                if(x.left!=null)
                    q.add(x.left);
                if(x.right!=null)
                    q.add(x.right);
                
            }
            else{
                if(q.isEmpty()==false)
                x.next=q.peek();
                
                if(x.left!=null)
                    q.add(x.left);
                if(x.right!=null)
                    q.add(x.right);
                
            }
            
        }
        return root;
        
    }
    public static HashSet<Node> left(Node root,HashSet<Node>set){
        if(root==null)
            return set;
        set.add(root);
        return left(root.right,set);
        
        
    }
}