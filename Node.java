// Rowan Karaca
// COM 212 - Program Zero
// October 6th 2026

/*
 * Program description:
 * This program defines a Node class that stores a person's name and
 * social security number (ssn), plus a pointer (next) to another Node,
 * so Nodes can be linked together into a list. The class provides
 * getters and setters for every field, and a getKey() method that
 * returns the last 4 digits of the ssn. TestNode.java is used to
 * create Nodes, change their fields, link them, and print the results.
 */

public class Node {
    // Instance variables
    private String name;  // person's name
    private int ssn;      // social security number (9 digits)
    private Node next;    // pointer to the next Node in a list
    private Node left;    // pointer to the left child in a BST
    private Node right;   // pointer to the right child in a BST

    // Default constructor: creates an empty Node (fields set later with setters)
    public Node() {
        name = "";
        ssn = 0;
        next = null;
        left = null;
        right = null;
    }

    // Constructor that sets the name and ssn right away
    public Node(String name, int ssn) {
        this.name = name;
        this.ssn = ssn;
        next = null;
        left = null;
        right = null;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSSN() {
        return ssn;
    }

    public void setSSN(int ssn) {
        this.ssn = ssn;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    // Key method: returns the last 4 digits of the ssn
    public int getKey() {
        return ssn % 10000;
    }
}
