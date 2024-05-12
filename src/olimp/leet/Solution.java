package olimp.leet;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        var start = new ListNode(0, head);
        var res = start;
        while (start.next != null) {
            var t = new ListNode(start.next.val, start.next.next);
            start = start.next.next;
            start.next.next.next = t;
            var v = start;
            while (v != null) {
                System.out.println(v.val);
                v = v.next;
            }

            start = start.next.next;
        }
        return res;
    }
}