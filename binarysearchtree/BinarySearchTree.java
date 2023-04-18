package binarysearchtree;

public class BinarySearchTree {
    Node root;
    
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // Constructor that builds a tree with 1 Node
    // public BinarySearchTree(int value) {
    //     Node newNode = new Node(value);
    //     root = newNode;
    // }

    // Constructor that builds an empty tree
    // Since root is not set to anything, it is equal to null by default
    // So setting root = null in this constructor is redundant and hence we can remove it
    // public BinarySearchTree() {
    //     root = null;
    // }
}
