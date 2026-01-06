package linkedlist.logic_building;

class ListNode {
    int val;
    ListNode next;
    ListNode() {
        val = 0;
        next = null;
    }
    ListNode(int data1) {
        val = data1;
        next = null;
    }
    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

public class RemoveNodeFromBack {
    /* 
    // Brue Force Approach
    // Time Complexity: O(L) + O(L-N) We are calculating the length of the linked list and then iterating up to the (L-N)th node of the linked list, where L is the total length of the list and N is the position of the node to delete.
    // Space Complexity: O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        ListNode temp = head;

        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        if (cnt == n) {
            ListNode newHead = head.next;
            return newHead;
        }

        int res = cnt - n;
        temp = head;

        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        ListNode delNode = temp.next;
        temp.next = temp.next.next;
        return head;
    }
    */

    // Time Complexity: O(N) since the fast pointer will traverse the entire linked list.
    // Space Complexity: O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPointer = head;
        for (int i = 0; i < n; i++) {
            fastPointer = fastPointer.next;
        }

        if (fastPointer == null) {
            ListNode newHead = head.next;
            return newHead;
        }

        ListNode slowPointer = head;
        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        ListNode delNode = slowPointer.next;
        slowPointer.next = slowPointer.next.next;

        return head;
    }    

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(5)
                                )
                        )
                )
        );

        System.out.print("Original List: ");
        printList(head);

        int n = 2; // remove 2nd node from end

        head = removeNthFromEnd(head, n);

        System.out.print("After Removing " + n + "th Node From End: ");
        printList(head);
    }
    
}