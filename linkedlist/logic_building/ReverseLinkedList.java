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

public class ReverseLinkedList {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
     public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode front = head;
        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
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
                                new ListNode(4)
                        )
                )
        );

        System.out.print("Original List: ");
        printList(head);

        ReverseLinkedList solution = new ReverseLinkedList();
        head = solution.reverseList(head);

        System.out.print("Reversed List: ");
        printList(head);
    }
}