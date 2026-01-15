package linkedlist.faq_medium;

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

public class FindMiddleOfLL {

    // Brute Force Approach
    // Time Complexity: O(N) + O(N/2) => O(N)
    // Space Complexity: O(1)
    /* 
    public static ListNode middleOfLinkedList(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        int middleNode = (cnt / 2) + 1;
        temp = head;

        while (temp != null) {
            middleNode--;
            if (middleNode == 0) break;
            temp = temp.next;
        }

        return temp;
    }
    */

    // Optimal Approach
    // Time Complexity: O(N/2), total iterations taken by the fast pointer to reach the end of the linked list are of the order O(N/2).
    // Space Complexity: O(1)
    public static ListNode middleOfLinkedList(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
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

        System.out.print("Linked List: ");
        printList(head);

        ListNode middle = middleOfLinkedList(head);

        System.out.println("Middle Node Value: " + middle.val);
    }
}