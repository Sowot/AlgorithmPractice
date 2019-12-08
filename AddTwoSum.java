/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807 (output format: 708)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class AddTwoSum {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static void display(ListNode node) {
        ListNode tmp = node;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
    }

    /**
     * from MSB -> LSB, add by bit and reverse the result, it must be true
     * l1 is the first bit of linkedlistA, l2 is of that of linkedlistB
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, res = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            res = res.next;
            if (p!= null) p = p.next;
            if (q!= null) q = q.next;
        }
        if (carry > 0) {
            res.next = new ListNode(carry);
        }
        // note not to return res.next
        return dummyHead.next;
    }

    public static void main(String[] args) {
        AddTwoSum addTwoSum = new AddTwoSum();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoSum.addTwoNumbers(l1, l2);
        display(res);
    }
}
