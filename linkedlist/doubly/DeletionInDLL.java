package linkedlist.doubly;

class Node {
    int data;
    Node next;
    Node prev;

    public Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class DeletionInDLL {

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return null;

        Node newHead = head.next;
        head.next = null;
        newHead.prev = null;
        return newHead;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
        temp.prev = null;
        return head;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static Node deleteKthNode(Node head, int k) {
        if (head == null)
            return null;

        int count = 1;
        Node curr = head;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (curr == null)
            return head;

        if (curr.prev == null && curr.next == null)
            return null;

        if (curr.prev == null) {
            head = curr.next;
            head.prev = null;
        } else if (curr.next == null) {
            curr.prev.next = null;
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        curr.next = null;
        curr.prev = null;
        return head;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static Node deleteNode(Node head, Node node) {
        if (node == null)
            return head;

        if (node.prev == null) {
            head = node.next;
            if (head != null)
                head.prev = null;
            return head;
        }

        if (node.next == null) {
            node.prev.next = null;
            node.prev = null;
            return head;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
        return head;
    }

    private static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node arrayToLinkedList(int[] nums) {
        if (nums.length == 0)
            return null;

        Node head = new Node(nums[0]);
        Node prev = head;

        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        Node head = arrayToLinkedList(nums);

        System.out.print("Original Linked List: ");
        printLL(head);

        head = deleteNode(head, head.next.next);
        System.out.print("After deleting node 3: ");
        printLL(head);

        head = deleteHead(head);
        System.out.print("After deleting head: ");
        printLL(head);

        head = deleteTail(head);
        System.out.print("After deleting tail: ");
        printLL(head);

        head = deleteKthNode(head, 3);
        System.out.print("After deleting 3rd node: ");
        printLL(head);
    }
}