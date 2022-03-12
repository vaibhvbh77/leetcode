/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        Node curr=head;
        Node ans=new Node(head.val);
        
        HashMap<Node,Node>map=new HashMap<>();
        map.put(head,ans);
        head=head.next;
        while(head!=null){
            map.put(head,map.getOrDefault(head,(new Node(head.val))));
            head=head.next;
        }
        while(curr!=null){
            Node temp = map.get(curr);
            temp.next = map.get(curr.next);
            temp.random = map.get(curr.random);
            curr = curr.next;
        }
        return ans;
        
    }
}