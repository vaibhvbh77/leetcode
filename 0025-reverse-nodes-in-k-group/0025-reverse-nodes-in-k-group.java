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
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseK(head,k);
    }
    public ListNode reverseK(ListNode head,int k){
        if(head==null)
        return null;

//  checking does this even exisits or not it yes we use temp for our purpose

    ListNode temp=head;
    int count=0;
    while(count<k){
        if(temp==null)
        return head;
        temp=temp.next;
        count++;
    }

    // temp is now pointing to next groups first element
    // 1-2-3-4 if k=2
    // 1-2-4-3 and prev is 4

    ListNode prev=reverseK(temp,k);

    // reverse the current group of the list for k nodes
    temp=head;
    count=0;
    //  temp on 1 , prev on 4

    while(count<k){
        // stores 2 first to stop it from loosign it
        ListNode next=temp.next; 
        temp.next=prev;
        // 1-4-3 2 in temp
        // next.next=temp
// should it be this ? to connect 2 to 1 /
// ANs no , each iteration only 1 reverse 

        // 2 will be used  in next. iteration
        prev=temp;
        temp=next;
        count++;

    }
    return prev;






    }
}
