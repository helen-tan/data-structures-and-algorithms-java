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
}