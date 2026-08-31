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
        int lengthA = 0;
        int lengthB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }

        int diff = Math.abs(lengthA - lengthB);
        tempA = headA;
        tempB = headB;

        if (lengthA >= lengthB) {
            for (int i = 0; i < diff; i++) {
                tempA = tempA.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                tempB = tempB.next;
            }
        }

        while(tempA!=null || tempB!=null){
            if(tempA==tempB){
                return tempA;
            }
            tempA=tempA.next;
            tempB=tempB.next;
        }

        return null;

    }
}