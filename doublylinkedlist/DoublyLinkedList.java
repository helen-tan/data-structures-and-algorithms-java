package doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
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

        // Check if DLL is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;

        return;
    }

    public Node removeLast() {
        // If DLL has no nodes
        if (length == 0)
            return null;

        Node temp = tail;

        // If DLL has 1 node
        if (length == 1) {
            head = null;
            tail = null;
        } else { // >=2 nodes
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;

        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        // If DLL is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;

        return;
    }

    public Node removeFirst() {
        Node temp = head;
        // If DLL is empty
        if (head == null)
            return null;
        // If DLL has 1 node
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
            head.prev = null;
        }
        length--;
        return temp;
    }

    // Get node at a specified index
    // The same way for singly linked list will work for doubly linked list
    // Except with doubly linked lists, the code can be more efficient as there are pointers pointing the other way
    public Node get(int index) {
        // Index out of range
        if (index < 0 || index >= length)  return null;

        Node temp = head;

        // If index is in the 1st half of the DLL, start iterating from the head. Else if index is in 2nd half, start iterating from the tail
        if (index < length/2) {
            for(int i = 0; i < index; i++ ) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    // Set the value of a node at a specified index
    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {   // If temp is pointing to a node (the get method can return a null if index is out of range)
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        // index out of range
        if (index < 0 || index > length) return false;
        // Adding infront
        if (index == 0) {
            prepend(value);
            return true;
        }
        // Adding behind
        if (index == length) {
            append(value);
            return true;
        }
        // Adding in the middle
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;

        before.next = newNode;
        newNode.prev = before;
        newNode.next = after;
        after.prev = newNode;

        length++;
        return true;
    }
}
