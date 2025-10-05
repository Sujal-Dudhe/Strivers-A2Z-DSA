package linkedlist.single;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class InsertionInLL {

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static Node insertAtTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static Node insertAtKthPosition(Node head, int data, int k) {
        if (k <= 0) return head; // invalid k

        // Insert at head
        if (k == 1) return new Node(data, head);

        // Traverse to (k-1)th node (1-based). If list is shorter than k-1, do nothing.
        Node curr = head;
        int pos = 1;
        while (curr != null && pos < k - 1) {
            curr = curr.next;
            pos++;
        }

        if (curr == null) {
            // k is greater than length + 1 -> do not insert, return head unchanged
            return head;
        }

        // Insert after curr
        curr.next = new Node(data, curr.next);
        return head;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static Node insertBeforeValueX(Node head, int data, int x) {
        if (head == null) {
            return null; // Invalid position
        }

        if (head.data == x) {
            return new Node(data, head);
        }

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == x) {
                Node newNode = new Node(data, curr.next);
                curr.next = newNode;
                break;
            }
            curr = curr.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
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

        n1 = insertAtHead(n1, 5);
        System.out.print("\nAfter inserting 5 at head: ");  
        printList(n1);
        
        n1 = insertAtTail(n1, 70);
        System.out.print("\nAfter inserting 70 at tail: ");
        printList(n1);  
        
        n1 = insertAtKthPosition(n1, 25, 4);
        System.out.print("\nAfter inserting 25 at 4th position: ");
        printList(n1);

        n1 = insertBeforeValueX(n1, 35, 40);
        System.out.print("\nAfter inserting 35 before value 40: ");
        printList(n1);
    }
}
