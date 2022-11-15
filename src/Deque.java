import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    Node first;
    Node last;
    int counter;

    private class Node {
        Node next;
        Node prev;
        Item value;

        public Node(Item value) {
            this.value = value;
        }
    }

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return (size() == 0);
    }

    // return the number of items on the deque
    public int size() {
        return this.counter;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        if (this.isEmpty()) {
            first = new Node(item);
            last = first;
        } else {
            Node current = first;
            first = new Node(item);
            current.next = first;
            first.prev = current;
        }
        counter++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        if (this.isEmpty()) {
            last = new Node(item);
            first = last;
        } else {
            Node current = last;
            last = new Node(item);
            current.prev = last;
            last.next = current;
        }

        counter++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = first.value;
        first = first.prev;
        first.next = null;
        counter--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }


        Item item = last.value;
        last = last.next;
        last.prev = null;
        counter--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator<Item>();
    }


    private class DequeIterator<Item> implements Iterator<Item> {

        private Node current;

        public DequeIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = (Item) current.value;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    // unit testing (required)
    public static void main(String[] args) {

    }

}