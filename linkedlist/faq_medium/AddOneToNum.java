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

public class AddOneToNum {

    // Time Complexity: O(N), because we traverse the linked list three times, each with a time complexity of O(N), resulting in O(3N), which simplifies to O(N)
    // Space Complexity: O(1)
    public static ListNode addOne(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        int carry = 1;

        while (temp != null) {
            int sum = temp.val + carry;
            carry = sum / 10;
            temp.val = sum % 10;

            if (carry == 0) break;

            if (temp.next == null && carry != 0) {
                temp.next = new ListNode(carry);
                break;
            }

            temp = temp.next;
        }

        head = reverse(head);

        return head;
    }

    private static ListNode reverse(ListNode head) {
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
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(9)
                )
        );

        System.out.print("Original Number: ");
        printList(head);

        head = addOne(head);

        System.out.print("After Adding One: ");
        printList(head);
    }
}