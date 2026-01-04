package linkedlist.logic_building;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SegregateOddAndEvenNodes {

    // Brute Force Approach
    // Time Complexity: O(2xN) for the following reasons:-Traversing the odd-indexed elements takes O(N/2) time, Traversing the even-indexed elements takes O(N/2) time. Updating the linked list with the values from the array takes O(N) time.
    // Space Complexity: O(N) because an additional list is used to store the grouped elements from the linked list.
/* 
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        List<Integer> array = new ArrayList<>();   
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            array.add(temp.data);
            temp = temp.next.next;
        }

        if (temp != null)
            array.add(temp.data);
 
        temp = head.next;

        while (temp != null && temp.next != null) {
            array.add(temp.data);
            temp = temp.next.next;
        }

        if (temp != null)
            array.add(temp.data);

        temp = head;
        int i = 0;

        while (temp != null) {
            temp.data = array.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }
*/


    // Optimal Approach
    // Time Complexity: O(N/2)x2 ~ O(N) because 0f iterating over the odd-indexed as well as the even-indexed elements.
    // Space Complexity: O(1)
    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode firstEvenNode = head.next;

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;

            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = firstEvenNode;

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
         ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.print("Original List: ");
        printList(head);

        SegregateOddAndEvenNodes solution = new SegregateOddAndEvenNodes();
        head = solution.oddEvenList(head);

        System.out.print("After Segregating Odd & Even Nodes: ");
        printList(head);
    }
}