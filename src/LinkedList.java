import java.util.Iterator;

public class LinkedList<E extends Comparable<E>> implements Iterable<E> {
    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            next = null;
        }

    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    public void addFirst(E obj) {
        Node<E> node = new Node<>(obj);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        currentSize++;
    }

    public void addLast(E obj) {
        Node<E> node = new Node<>(obj);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        currentSize++;
    }

    public E removeFirst() {
        if (head == null)
            return null;
        E temp = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        currentSize--;
        return temp;
    }

    public E removeLast() {
        if (head == null)
            return null;
        if (head == tail)
            return removeFirst();

        Node<E> current = head, previous = null;
        while (current != tail) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }

    public E remove(E obj) {
        Node<E> current = head, previous = null;
        while (current != null) {
            if (obj.compareTo(current.data) == 0) {
                if (head == current)
                    return removeFirst();
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean contain(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.compareTo(current.data) == 0)
                return true;
            current = current.next;
        }
        return false;
    }

    public int size() {
        return currentSize;
    }

    public void clear() {
        head = tail = null;
        currentSize = 0;
    }

    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}