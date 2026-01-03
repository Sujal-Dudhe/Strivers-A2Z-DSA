package linkedlist.logic_building;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }
    
    ListNode(int data) {
        this.val = data;
        this.next = null;
    }
    
    ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }
}

public class AddTwoNumbersInLL {

    // Time Complexity: O(max(M, N)), The algorithm traverses both lists at most once, hence, the time complexity depends on the length of the longer list.
    // Space Complexity: O(max(M,N)) The length of the new list is at most max(M, N)+1.
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while(temp1 != null || temp2 != null || carry != 0) {
            int sum = 0;

            if (temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }

            sum += carry;

            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);
            curr.next = newNode;
            curr = curr.next;
        }

        return dummyNode.next;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val  + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
    
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.print("Sum List: ");
        printList(result);
    }
}
