package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    // Class variables
    private Node head;
    private Node tail;
    private int length;

    // Node class (inner/nested class)
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    // Constructor - initializes LL's head & tail to a new node
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        return head;
    }

    public Node getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
        return tail;
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        // If linkedlist is empty, head & tail should point at the new node
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else { // linkedlist not empty
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        // Scenario 1: linkedlist starts empty
        if (length == 0)
            return null;

        Node temp = head;
        Node pre = head;
        // Scenario 2: If >1 items in linkedlist
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre; // make tail point to the 2nd last node
        tail.next = null; // break away last node by making 2nd last node point to null
        length--;

        // Scenario 3: Start out with only 1 item in linkedlist (temp.next will = null
        // so while loop above won't run)
        if (length == 0) { // when there is only 1 item, length = 0 as it was decremented to 0 above (1 -1
                           // = 0). A problem to handle as head & tail shouldnt be pointing to a node when
                           // length = zero
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        // If start w empty linked list
        if (length == 0) { // of if head = null
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        // Case 1: Empty linked list
        if (length == 0)
            return null;

        // Case 2: Multiple items in linked list
        Node temp = head;

        head = head.next;
        temp.next = null;
        length--;

        // Case 3: Start with 1 item in linked list (Tail will still be pointing to the
        // node after the above steps)
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    // Get a Node at a specific index
    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;

        int count = 0;
        Node temp;
        temp = head;

        while (count != index) {
            temp = temp.next;
            count++;
        }
        // or
        // for(int i = 0; i < index; i++){
        // temp = temp.next;
        // }
        return temp;
    }

    // Set the value of a node at a specific index
    public boolean set(int index, int value) {
        // Get a pointer to the Node at the specified index
        Node temp = get(index); // Leverage the get() method!

        if (temp != null) { // Check if temp is pointing to a node or null
            temp.value = value;
            return true;
        }
        return false;
    }

    // Insert a node of a particular value at a specified index
    public boolean insert(int index, int value) {
        // If index out of range
        if (index < 0 || index > length)
            return false;

        // If index is 0
        if (index == 0) {
            prepend(value);
            return true;
        }
        // If index = length (insert at the end/append)
        if (index == length) {
            append(value);
            return true;
        }
        // If insert in the middle of linked list
        Node newNode = new Node(value);
        Node temp = get(index - 1); // Point at the node 1 place before the index we want to insert it

        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    // Remove a node at a specified index
    public Node remove(int index) {
        // If index out of range
        if (index < 0 || index >= length)
            return null;
        // If index = 0 (remove first item)
        if (index == 0)
            return removeFirst();
        // If index = length - 1 (remove last item)
        if (index == length - 1)
            return removeLast();

        // If index in the middle
        Node prev = get(index - 1);
        Node temp = prev.next; // More efficient than temp = get(index), as get method is O(n). This way is
                               // O(1)

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    // Reverse a linked list
    public void reverse() {
        // Reverse head and tail
        Node temp = head;
        head = tail;
        tail = temp;
        // Flip the next pointers
        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    // INTERVIEW QNS: Find Middle Node of LL (without using length)
    public Node findMiddleNode() {
        Node fast = head;
        Node slow = head;

        // Traverse the linked list with two pointers: slow and fas
        while (fast != null && fast.next != null) {
            slow = slow.next; // slow moves one node at a time
            fast = fast.next.next; // while fast moves two nodes at a time
        }

        // By the time the fast pointer reaches the end of the list, the slow pointer
        // will be at the middle node.
        return slow;
    }

    // INTERVIEW QNS: Check if LL has a loop
    public boolean hasLoop() {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow pointer meets fast pointer, then there is a loop in the linked list
            if (fast == slow)
                return true;
        }

        // If the loop has not been detected after the traversal, then there is no loop
        // in the linked list
        return false;
    }

    // INTERVIEW QNS: Find Kth Node from the end
    public Node findKthFromEnd(int k) {
        // If k is out of range
        if (k <= 0 || k > length)
            return null;
        // If k is 1, meaning last node
        if (k == 1)
            return getTail();
        // If k = length, meaning 1st node
        if (k == length)
            return getHead();
        // In between nodes
        return get(length - k);
    }

    // INTERVIEW QNS: Find Kth Node from the end (ALTERNATIVE METHOD)
    public Node findKthNode2(int k) {
        Node slow = head;
        Node fast = head;

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            // If k is out of bounds, return null
            if (fast == null) return null;
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }
        // Since the fast pointer is already k steps ahead of the slow pointer, 
        // when the fast pointer reaches the end of the LinkedList, the slow pointer will be at the kth node from the end.
        return slow; // Return the kth node from the end (slow pointer)
    }

    // INTERVIEW QNS: Remove Duplicates
    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();

        Node previous = null;
        Node current = head;

        while (current != null) {
            // Check if value is already in Hashset (is a duplicate)
            // If yes, remove the node from the LL. If not, add to Hashset. 
            if (values.contains(current.value)) {
                previous.next = current.next;
                length--;
            } else {
                values.add(current.value);
                previous = current;
            }
            // Move to the next node
            current = current.next;
        }
    }
}