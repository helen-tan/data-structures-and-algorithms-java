package stack;

import java.util.ArrayList;

// Stack implemented using an ArrayList
public class Stack2<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) { // generic type T
         // Add given value at the end of an ArrayList called stackList
         stackList.add(value);
    }
    
    // Remove last element of Stack
    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1); // stackList is zero-indexed
    }
}
