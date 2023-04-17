package stack;

// We use a Singly linked-linked list to represent a stack. Visualized to be vertical
public class Stack {
    private Node top; // Would be "head" in a lniked list
    private int height;
    // In a stack we don't need bottom (would be "tail" in a Linked List)

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop() {
        System.out.println("Top: " + top.value);
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }
}
