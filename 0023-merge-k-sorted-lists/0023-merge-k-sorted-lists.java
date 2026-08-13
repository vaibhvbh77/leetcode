/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        /*
         * ============================================================
         * UNDERSTANDING THE INPUT
         * ============================================================
         *
         * ListNode[] lists = an ARRAY of linked lists.
         *
         *      lists
         *        ↓
         *   ┌─────────┬─────────┬─────────┐
         *   │ lists[0]│ lists[1]│ lists[2]│
         *   └────┬────┴────┬────┴────┬────┘
         *        ↓         ↓         ↓
         *      1→4→5     1→3→4     2→6
         *
         * All individual linked lists are already SORTED.
         *
         * Goal:
         *
         *      1→4→5
         *      1→3→4
         *      2→6
         *
         *      ↓
         *
         *      1→1→2→3→4→4→5→6
         */


        /*
         * ============================================================
         * NAIVE APPROACH
         * ============================================================
         *
         * 1. Take all values from all linked lists.
         *
         *      1, 4, 5, 1, 3, 4, 2, 6
         *
         * 2. Sort them.
         *
         *      1, 1, 2, 3, 4, 4, 5, 6
         *
         * 3. Create a new linked list using the sorted values.
         *
         * Time:  O(N log N)
         * Space: O(N)
         *
         * N = total number of nodes across all lists.
         *
         * ------------------------------------------------------------
         *
         * ArrayList<Integer> list = new ArrayList<>();
         *
         * for (int i = 0; i < lists.length; i++) {
         *
         *     ListNode curr = lists[i];
         *
         *     while (curr != null) {
         *         list.add(curr.val);
         *         curr = curr.next;
         *     }
         * }
         *
         * Collections.sort(list);
         *
         * ListNode dummy = new ListNode(0);
         * ListNode curr = dummy;
         *
         * for (int i = 0; i < list.size(); i++) {
         *     curr.next = new ListNode(list.get(i));
         *     curr = curr.next;
         * }
         *
         * return dummy.next;
         */


        /*
         * ============================================================
         * EFFICIENT APPROACH — MIN HEAP / PRIORITY QUEUE
         * ============================================================
         *
         * Important observation:
         *
         * Every individual list is ALREADY SORTED.
         *
         * Therefore, we don't need to sort ALL N elements again.
         *
         * At any moment, we only need to compare the current
         * smallest node from each list.
         *
         * Example:
         *
         *      List 1: 1 → 4 → 5
         *      List 2: 1 → 3 → 4
         *      List 3: 2 → 6
         *
         * Current candidates:
         *
         *      1, 1, 2
         *
         * Smallest = 1
         *
         * Take that 1 and move that list forward.
         *
         * Now candidates might be:
         *
         *      4, 1, 2
         *
         * Smallest = 1
         *
         * So we need a data structure that can quickly give us
         * the SMALLEST element.
         *
         * That data structure is a MIN HEAP / PriorityQueue.
         *
         * ============================================================
         */


        /*
         * PriorityQueue is a MIN HEAP by default.
         *
         * But ListNode does not know how to compare itself with
         * another ListNode.
         *
         * Therefore, we provide a comparator:
         *
         *      (a, b) -> a.val - b.val
         *
         * This tells PriorityQueue:
         *
         *      "Compare ListNodes using their val."
         *
         * So the smallest val will come out first.
         *
         * Example:
         *
         *      Node(4)
         *      Node(1)
         *      Node(2)
         *
         * pq.poll() → Node(1)
         */
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);


        /*
         * Put the FIRST node of every linked list into the heap.
         *
         * We don't put every node.
         *
         * We only need one current candidate from each list.
         *
         * Example:
         *
         *      1 → 4 → 5
         *      1 → 3 → 4
         *      2 → 6
         *
         * Heap initially:
         *
         *      [1, 1, 2]
         */
        for (int i = 0; i < lists.length; i++) {

            // Important:
            // Don't add null heads.
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }


        /*
         * Dummy node makes building the answer easier.
         *
         * dummy → actual answer
         *
         * curr will always point to the last node
         * in our answer.
         */
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;


        /*
         * Keep taking the smallest current node.
         */
        while (!pq.isEmpty()) {

            /*
             * Remove the smallest node from the heap.
             *
             * Because of our comparator:
             *
             *      pq.poll()
             *
             * gives the node with the smallest val.
             */
            ListNode out = pq.poll();


            /*
             * Add this node to our answer.
             */
            curr.next = out;
            curr = out;


            /*
             * IMPORTANT:
             *
             * Suppose we removed:
             *
             *      1 → 4 → 5
             *      ↑
             *     out
             *
             * We just used 1.
             *
             * The next candidate from this list is 4.
             *
             * Therefore, add out.next to the heap.
             */
            if (out.next != null) {
                pq.add(out.next);
            }
        }


        /*
         * dummy itself is not part of the answer.
         *
         * Return the actual first node.
         */
        return dummy.next;
    }
}


/*
 * ================================================================
 * COMPLEXITY
 * ================================================================
 *
 * Let:
 *
 *      N = total number of nodes across all lists
 *      K = number of linked lists
 *
 * Every node:
 *
 *      enters the heap once
 *      leaves the heap once
 *
 * Heap contains at most K nodes.
 *
 * Each heap operation:
 *
 *      O(log K)
 *
 * Therefore:
 *
 *      TIME  = O(N log K)
 *      SPACE = O(K)
 *
 *
 * NAIVE:
 *
 *      TIME  = O(N log N)
 *      SPACE = O(N)
 *
 * EFFICIENT:
 *
 *      TIME  = O(N log K)
 *      SPACE = O(K)
 *
 * Main reason efficient solution works:
 *
 *      We USE the fact that every individual list is already sorted.
 *
 * ================================================================
 */