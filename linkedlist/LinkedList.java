package linkedlist;

public class LinkedList {
    // Class variables
    private Node head;
    private Node tail;
    private int length;

    // Node class (inner/nested class)
	class Node {
        int value;
        Node next;
        
        Node (int value) {
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

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
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
        if (length == 0) return null;

        Node temp = head;
        Node pre = head;
        // Scenario 2: If >1 items in linkedlist
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;       // make tail point to the 2nd last node
        tail.next = null; // break away last node by making 2nd last node point to null
        length--;

        // Scenario 3: Start out with only 1 item in linkedlist (temp.next will = null so while loop above won't run)
        if (length == 0) { // when there is only 1 item, length = 0 as it was decremented to 0 above (1 -1 = 0). A problem to handle as head & tail shouldnt be pointing to a node when length = zero
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
        if (length == 0) return null;
        
        // Case 2: Multiple items in linked list
        Node temp = head;

        head = head.next;
        temp.next = null;
        length--;

        // Case 3: Start with 1 item in linked list (Tail will still be pointing to the node after the above steps)
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    // Get a Node at a specific index
    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        int count = 0;
        Node temp;
        temp = head;

        while(count != index) {
            temp = temp.next;
            count++;
        }
        // or
        // for(int i = 0; i < index; i++){
        //     temp = temp.next;
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
}