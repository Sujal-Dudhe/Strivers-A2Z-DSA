package linkedlist.single;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeletionInLL {

    // Time Complexity: O(1), for updating the head pointer
    // Space Complexity: O(1)
    public static Node deleteHead(Node head) {
        if (head == null) return null;

        head = head.next;
        return head;
    }

    // Time Complexity: O(N) Since we may need to traverse the entire list
    // Space Complexity: O(1)
    // Returns null if the list is empty or has only one node.
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) return null;

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }
    // Time Complexity: O(N) Since we may need to traverse the entire list
    // Space Complexity: O(1)
    public static Node deleteKthNode(Node head, int k) {
        if (head == null || k <= 0) return null;

        if (k == 1) {
            return deleteHead(head);
        }

        Node current = head;
        // Move current to the (k-1)th node (1-based index), so current.next is the kth node to delete
        for (int i = 0; current != null && i < k - 2; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            return head; // k is greater than the number of nodes
        }

        Node nodeToDelete = current.next;
        current.next = nodeToDelete.next;   

        return head;
    }

    // Time Complexity: O(N) Since we may need to traverse the entire list
    // Space Complexity: O(1)
    public static Node deleteNodeWithValueX(Node head, int x) {
        if (head == null) return null;

        if (head.data == x) {
            return deleteHead(head);
        }

        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.data == x) {
                prev.next = current.next;
                return head;
            }
            prev = current;
            current = current.next;
        }

        return head; // x not found
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        n1.next = new Node(20);
        n1.next.next = new Node(30);    
        n1.next.next.next = new Node(40);
        n1.next.next.next.next = new Node(50);
        n1.next.next.next.next.next = new Node(60);

        System.out.print("Original Linked List: ");
        printList(n1);

        n1 = deleteHead(n1);
        System.out.print("\nAfter deleting head: ");
        printList(n1);

        n1 = deleteTail(n1);
        System.out.print("\nAfter deleting tail: ");    
        printList(n1);

        n1 = deleteKthNode(n1, 2);
        System.out.print("\nAfter deleting 2nd node: ");
        printList(n1);

        n1 = deleteNodeWithValueX(n1, 40);
        System.out.print("\nAfter deleting node with value 40: ");  
        printList(n1);
    }
}
