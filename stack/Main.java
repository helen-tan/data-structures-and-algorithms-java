package stack;

public class Main {
    public static void main(String[] args) {
        // Stack myStack = new Stack(4);

        // myStack.getTop();
        // myStack.getHeight();

        // myStack.printStack();

        // Push
        // Stack myStack = new Stack(2);
        // myStack.push(1);
        // myStack.printStack();

        // Pop
        Stack myStack = new Stack(7);
        myStack.push(23);
        myStack.push(3);
        myStack.push(11);

        myStack.pop();
        myStack.printStack();
    }
}
