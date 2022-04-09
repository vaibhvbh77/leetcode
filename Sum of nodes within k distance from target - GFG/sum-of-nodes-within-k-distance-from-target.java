// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            solver x = new solver();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class solver{
    static Node targetNode = null;
    private static void findParent(Node root,HashMap<Node,Node> hmap){
        if(root == null){
            return;
        }
        if(root.left != null){
            hmap.put(root.left,root);
            findParent(root.left,hmap);
        }
        if(root.right != null){
            hmap.put(root.right,root);
            findParent(root.right,hmap);
        }
    }
    private static void findTarget(Node root, int target){
        if(root == null){
            return;
        }
        if(root.data == target){
            targetNode = root;
            return;
        }
        findTarget(root.left,target);
        findTarget(root.right,target);
        
    }
    static int sum_at_distK(Node root, int target, int k){
        //find parent nodes to each node to backtrack
        //do bfs from target node using parent hashmap and vis
        
        HashMap<Node,Node> hmap = new HashMap<Node,Node>();
        hmap.put(root,null);//bcoz root node no parent
        findParent(root,hmap);
        // we can find targetNode in prev traversal only, but to make it clear, fo for anotehr call
        findTarget(root,target);
        
        // do bfs just like graph
        Queue<Node> q = new ArrayDeque<Node>();
        q.offer(targetNode);
        HashMap<Node,Boolean> visited = new HashMap<Node,Boolean>();
        int sum = targetNode.data;
        int distance = 0;
        visited.put(targetNode,true);
        while(distance != k && !q.isEmpty()){
            int qSize = q.size();
            while(qSize>0){
                Node curr = q.poll();
                if(curr.left!=null && !visited.containsKey(curr.left)){
                    q.offer(curr.left);
                    sum += curr.left.data;
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && !visited.containsKey(curr.right)){
                    q.offer(curr.right);
                    sum += curr.right.data;
                    visited.put(curr.right,true);
                }
                // ancestor
                if(hmap.get(curr) != null && !visited.containsKey(hmap.get(curr))){
                    q.offer(hmap.get(curr));
                    sum += hmap.get(curr).data;
                    visited.put(hmap.get(curr),true);
                }
                qSize -= 1;
            }
            distance += 1;
        }
        return sum;
    }
}