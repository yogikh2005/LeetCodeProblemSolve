class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head; 

        while (curr != null && curr.next != null) {
            int gcdValue = gcd(curr.val, curr.next.val);
            ListNode newNode = new ListNode(gcdValue);

            newNode.next = curr.next;
            curr.next = newNode;

            curr = newNode.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
