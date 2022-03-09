/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        ListNode dummy=new ListNode(-1);
         dummy.next=head;
        ListNode it=head;
        ListNode prev=dummy;
        
        while(it!=null&&it.next!=null){
            
            boolean flag=false;
          while(it!=null&&it.next!=null&&it.val==it.next.val){
              flag=true;
              it=it.next;
          }
            
            if(!flag){
                prev=prev.next;
            }
            else
                prev.next=it.next;
            
            it=it.next;
            
        }
        return dummy.next;
    }
}