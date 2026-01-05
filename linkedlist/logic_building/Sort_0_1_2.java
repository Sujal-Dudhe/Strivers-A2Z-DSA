package linkedlist.logic_building;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Sort_0_1_2 {

    /* 
    // Brute Force Approach
    // Time Complexity: 
    // Space Complexity: 
    public static ListNode sortList(ListNode head) {
        ListNode temp = head;

        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        while (temp != null) {
            if (temp.val == 0) cnt0++;
            else if (temp.val == 1) cnt1++;
            else cnt2++;

            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (cnt0 != 0) {
                temp.val = 0;
                cnt0--;
            } else if (cnt1 != 0) {
                temp.val = 1;
                cnt1--;
            } else if (cnt2 != 0) {
                temp.val = 2;
                cnt2--;
            }

            temp = temp.next;
        }

        return head;
    }
    */

    // Optimal Approach 
    // Time Complexity: O(N), because the code traverses the linked list once.
    // Space Complexity: O(1)
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zero.next = curr;
                zero = curr;
            } else if (curr.val == 1) {
                one.next = curr;
                one = curr;
            } else {
                two.next = curr;
                two = curr;
            }

            curr = curr.next;
        }

        zero.next = (oneHead.next != null)? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        ListNode newHead = zeroHead.next;

        return newHead;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode( 2, new ListNode( 0, new ListNode( 1, new ListNode( 2, new ListNode(0))))));

        System.out.print("Original List: ");
        printList(head);

        head = sortList(head);

        System.out.print("Sorted List: ");
        printList(head);
    }
}