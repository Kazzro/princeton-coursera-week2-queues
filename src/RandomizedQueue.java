import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class Node {
        Node next;
        Item value;

        public Node(Item item) {
            this.value = item;
            this.next = null;
        }
    }

    Node first;
    int counter;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.first = null;
        this.counter = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return this.counter == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return this.counter;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        Node current = first;
        if (size() == 0) {
            first = new Node(item);
            counter++;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(item);
            counter++;
        }
    }

    // remove and return a random item
    public Item dequeue() {

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (counter == 1) {
            Item item = first.value;
            first = null;
            counter--;
            return item;
        }

        int zaehler = (int) (Math.random() * counter);
        counter--;
        if (zaehler == 0) {
            Item item = first.value;
            first = first.next;
            return item;
        }
        Node current = first;
        Node oldCurrent = null;
        while (zaehler > 1) {
            oldCurrent = current;
            current = current.next;

            zaehler--;
        }
        Item item = current.value;
        if (oldCurrent != null) {
            oldCurrent.next = current.next;
        }
        return item;

    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        int zaehler = (int) (Math.random() * counter);
        if (zaehler == 0) {
            return first.value;
        }
        Node current = first;
        while (zaehler-- >= 1) {
            current = current.next;
        }
        return current.value;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.value;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}