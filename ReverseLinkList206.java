class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // store next
            curr.next = prev;              // reverse pointer
            prev = curr;                   // move prev
            curr = nextTemp;               // move curr
        }

        return prev; // new head
    }
}
