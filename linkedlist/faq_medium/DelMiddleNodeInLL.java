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

public class DelMiddleNodeInLL {
    /* 
    // Brute Force Approach
    // Time Complexity: O(N) + O(N/2) => O(N)
    // Space Complexity: O(1)
    public static ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) return null;
        
        ListNode temp = head;
        int nodeCount = 0;
        while (temp != null) {
            nodeCount++;
            temp = temp.next;
        }

        int reset = nodeCount / 2;
        temp = head;
        while (temp != null) {
            reset--;
            if (reset == 0) {
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }

        return head;
    }
    */

    // Optimal Approach 
    // Time Complexity: O(N/2) ~ O(N)
    // Space Complexity: O(1)
    public static ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) return null;
        
        ListNode slowPointer = head;
        ListNode fastPointer = head.next.next;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

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

        head = deleteMiddle(head);

        System.out.print("After Deleting Middle Node: ");
        printList(head);
    }
}