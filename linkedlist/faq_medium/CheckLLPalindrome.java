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

public class CheckLLPalindrome {

    /* 
    // Brute Force Approach
    // Time Complexity: O(2N), because we need to traverse the linked list twice.
    // Space Complexity: O(N), We use a stack to store the values of the linked list.
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> nodeData = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            nodeData.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.val != nodeData.pop()) return false;
            temp = temp.next;
        }

        return true;
    }
    */

    // Optimal Approach
    // Time Complexity: O(2N)
    // Space Complexity: O(1)
    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        ListNode newHead = reverseLinkedList(slowPointer.next);

        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = newHead;

        while (secondHalfPointer != null) {
            if (firstHalfPointer.val != secondHalfPointer.val) {
                reverseLinkedList(newHead);
                return false;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        reverseLinkedList(newHead);
        return true;
    }   

    private static ListNode reverseLinkedList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
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
        // Palindrome list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        2,
                                        new ListNode(1)
                                )
                        )
                )
        );

        System.out.print("Linked List: ");
        printList(head);

        boolean result = isPalindrome(head);
        System.out.println("Is Palindrome: " + result);
    }
}