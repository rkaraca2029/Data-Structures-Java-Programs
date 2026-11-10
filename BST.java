//Rowan Karaca
//October 28th 2026
//This program implements a binary search tree with the following functions:
//- insert: Inserts a new node into the tree
//- search: Searches for a node in the tree
//- delete: Deletes a node from the tree
//- traverse: Traverses the tree in order
//- printTree: Prints the tree in a structured format
//- isEmptyTree: Checks if the tree is empty
//- createEmptyTree: Creates an empty tree
//Nodes are ordered by getKey() (last 4 digits of the ssn) and linked
//with left and right pointers (no parent pointer).

public class BST {

    private Node root;

    public BST() {
        createEmptyTree();
    }

    public void createEmptyTree() {
        root = null;
    }

    public boolean isEmptyTree() {
        return root == null;
    }

    // Inserts x as a new leaf in the correct spot
    public void insert(Node x) {
        x.setLeft(null);
        x.setRight(null);
        root = insert(root, x);
    }

    private Node insert(Node current, Node x) {
        if (current == null) {
            return x;
        }
        if (x.getKey() < current.getKey()) {
            current.setLeft(insert(current.getLeft(), x));
        } else {
            current.setRight(insert(current.getRight(), x));
        }
        return current;
    }

    // Returns the node with the given key, or null if it is not in the tree
    public Node search(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.getKey()) {
                return current;
            }
            if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    // Removes the node with x's key from the tree
    public void delete(Node x) {
        if (search(x.getKey()) == null) {
            System.out.println("Key " + x.getKey() + " is not in the tree");
            return;
        }
        root = delete(root, x.getKey());
    }

    // Returns the subtree rooted at current with key removed
    private Node delete(Node current, int key) {
        if (current == null) {
            return null;
        }
        if (key < current.getKey()) {
            current.setLeft(delete(current.getLeft(), key));
            return current;
        }
        if (key > current.getKey()) {
            current.setRight(delete(current.getRight(), key));
            return current;
        }

        // Found it: replace current with the right child, left child,
        // or (two children) its in-order successor
        Node replacement;
        if (current.getLeft() == null) {
            replacement = current.getRight();
        } else if (current.getRight() == null) {
            replacement = current.getLeft();
        } else {
            replacement = findMin(current.getRight());
            replacement.setRight(deleteMin(current.getRight()));
            replacement.setLeft(current.getLeft());
        }
        current.setLeft(null);
        current.setRight(null);
        return replacement;
    }

    private Node findMin(Node current) {
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    // Returns the subtree rooted at current with its smallest node unlinked
    private Node deleteMin(Node current) {
        if (current.getLeft() == null) {
            return current.getRight();
        }
        current.setLeft(deleteMin(current.getLeft()));
        return current;
    }

    // Prints the keys in sorted (in-order) order on one line
    public void traverse() {
        traverse(root, true);
        System.out.println();
    }

    // Returns whether the next key printed will still be the first one
    private boolean traverse(Node current, boolean first) {
        if (current == null) {
            return first;
        }
        first = traverse(current.getLeft(), first);
        if (!first) {
            System.out.print(" ");
        }
        System.out.print(current.getKey());
        return traverse(current.getRight(), false);
    }

    // Prints each node (preorder) with the keys of its left and right
    // children, followed by a blank line
    public void printTree() {
        printTree(root);
        System.out.println();
    }

    private void printTree(Node current) {
        if (current == null) {
            return;
        }
        System.out.println(current.getKey()
                + " Left: " + keyOrNull(current.getLeft())
                + " Right: " + keyOrNull(current.getRight()));
        printTree(current.getLeft());
        printTree(current.getRight());
    }

    private String keyOrNull(Node x) {
        if (x == null) {
            return "null";
        }
        return String.valueOf(x.getKey());
    }
}
