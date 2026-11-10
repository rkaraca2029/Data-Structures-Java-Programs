/* This program implements a queue using an array with max size of 100

The following functions are implemented:
- enqueue: Adds an element to the rear of the queue
- dequeue: Removes an element from the front of the queue
- isEmpty: Checks if the queue is empty
- front: Returns the element at the front of the queue
- printQueue: Prints head, tail, and the key of each element in the queue 

Rowan Karaca, October 24, 2026

*/

public class QueueA {
    private Node[] queue;
    private int head;
    private int tail;
    private int n;

    public QueueA() {
        queue = new Node[100];
        head = 0;
        tail = 0;
        this.n = 0;
    }
    public void enqueue(Node x) {
        if (this.n == queue.length) {
            System.out.println("Queue is full");
            return;
        }
        queue[tail] = x;
        tail = (tail + 1) % queue.length;
        this.n++;
    }
    public Node dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Node temp = queue[head];
        head = (head + 1) % queue.length;
        this.n--;
        return temp;
    }
    public boolean isEmpty() {
        return this.n == 0;
    }
    public Node front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue[head];
    }
    public void printQueue() {
        System.out.println(head);
        System.out.println(tail);
        for (int i = 0; i < n; i++) {
            System.out.println(queue[(head + i) % queue.length].getKey());
        }
    }
}