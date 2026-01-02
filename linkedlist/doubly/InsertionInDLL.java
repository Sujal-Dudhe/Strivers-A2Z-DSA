package linkedlist.doubly;

class Node {
    int data;
    Node next;
    Node prev;

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node prev, Node next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class InsertionInDLL {

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static Node insertBeforeHead(Node head, int data) {
        Node newNode = new Node(data, null, head);
        if (head != null) {
            head.prev = newNode;
        }
        return newNode;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static Node insertBeforeTail(Node head, int data) {
        if (head == null)
            return new Node(data);
        if (head.next == null)
            return insertBeforeHead(head, data);

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node prev = tail.prev;

        Node newNode = new Node(data, prev, tail);

        prev.next = newNode;
        tail.prev = newNode;

        return head;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static Node insertBeforeKthPosition(Node head, int data, int k) {
        if (k <= 0) {
            System.out.println("Invalid position");
            return head;
        }
        if (k == 1)
            return insertBeforeHead(head, data);

        Node curr = head;
        int count = 1;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (curr == null) {
            System.out.println("Position out of bounds");
            return head;
        }

        Node prev = curr.prev;
        Node newNode = new Node(data, prev, curr);
        prev.next = newNode;
        curr.prev = newNode;
        return head;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static void insertBeforeGivenNode(Node givenNode, int data) {
        if (givenNode == null) {
            System.out.println("Given node cannot be null");
            return;
        }
        Node prev = givenNode.prev;

        if (prev == null) {
            System.out.println("Cannot insert before head using insertBeforeGivenNode. Use insertBeforeHead instead.");
            return;
        }
        Node newNode = new Node(data, prev, givenNode);
        prev.next = newNode;
        givenNode.prev = newNode;
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

        System.out.print("After inserting 10 before 3rd node: ");
        if (head != null && head.next != null && head.next.next != null) {
            insertBeforeGivenNode(head.next.next, 10);
        }
        printLL(head);

        System.out.print("After inserting 20 before head: ");
        head = insertBeforeHead(head, 20);
        printLL(head);

        System.out.print("After inserting 30 before tail: ");
        head = insertBeforeTail(head, 30);
        printLL(head);

        System.out.print("After inserting 40 before 4th node: ");
        head = insertBeforeKthPosition(head, 40, 4);
        printLL(head);
    }
}
