import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int counter;

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
            throw new IllegalArgumentException();
        }
        Node add = new Node(item);

        if (this.isEmpty()) {
            first = add;
            last = first;
        } else {
            add.next = first;
            first.prev = add;
            first = add;
        }
        counter++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node add = new Node(item);
        if (this.isEmpty()) {
            last = add;
            first = last;
        } else {
            add.prev = last;
            last.next = add;
            last = add;
        }
        counter++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = first.value;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        counter--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }


        Item item = last.value;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }
        counter--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = current.value;
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
//        Deque<String> deque = new Deque<>();
//        deque.addFirst("to chew bubblegum");
//        deque.addLast("and");
//        deque.addFirst("I'm here");
//        deque.addLast("kick ass");
//        for (String s : deque) {
//            System.out.print(s + " ");
//        }
//        System.out.println("\n\n" + deque.removeFirst());
//        System.out.println(deque.removeLast());
//        deque.addLast("I'm all out of bubblegum");
//        System.out.println(deque.removeFirst());
//        System.out.println();
//        for (String s : deque) {
//            System.out.print(s + " ");
//        }

        Deque<Integer> deque2 = new Deque<>();
        deque2.addFirst(1);
        System.out.println(deque2.removeLast());
        System.out.println(deque2.counter);
    }

}