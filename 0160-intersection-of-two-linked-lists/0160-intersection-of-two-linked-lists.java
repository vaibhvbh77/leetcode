/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count=1;
        int count2=1;
        ListNode temp1=headA;
        ListNode temp2=headB;
        while(temp1!=null){
            count++;
            temp1=temp1.next;
        }

          while(temp2!=null){
            count2++;
            temp2=temp2.next;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        int diff=Math.abs(count-count2);

        if(count>count2){
            while(diff!=0){
                p1=p1.next;
                diff--;
            }
        }

        else if(count<count2){
            while(diff!=0){
                p2=p2.next;
                diff--;
            }
        }

        while(p1!=null && p2!=null){
            if(p1==p2) return p1;
            p1=p1.next;
            p2=p2.next;
        }




    return null;
    }
}