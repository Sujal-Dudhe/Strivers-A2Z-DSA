package linkedlist.single;
import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Traversal {

    // Time Complexity: O(N) Since we traverse the entire list once
    // Space Complexity: O(N) for storing the result in a list
    public static List<Integer> LLTraversal(Node head) {
        List<Integer> result = new ArrayList<>();
        Node current = head;
        while (current != null) {
            result.add(current.data);
            current = current.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30); 
        Node n4 = new Node(40);

        n1.next = n2;
        n2.next = n3;    
        n3.next = n4;

        List<Integer> result = LLTraversal(n1);

        System.out.print("Linked List Traversal: ");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}