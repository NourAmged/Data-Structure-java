import java.lang.reflect.Array;

public class Heap<E extends Comparable<E>> {
    private int lastPosition;
    private final int size;
    private E[] array;

    @SuppressWarnings("unchecked")
    Heap(int size) {
        this.size = size;
        this.lastPosition = -1;
        this.array = (E[]) Array.newInstance(Comparable.class, size);
    }

    public void add(E obj) {
        if (lastPosition + 1 == size) {
            throw new IllegalStateException("Heap is full");
        }
        array[++lastPosition] = obj;
        tickleUp(lastPosition);
    }

    public E remove() {
        if (lastPosition == -1) {
            throw new IllegalStateException("Heap is empty");
        }
        E tmp = array[0];
        swap(0, lastPosition--);
        tickleDown(0);
        return tmp;
    }

    private void swap(int from, int to) {
        E tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    private void tickleUp(int position) {
        if (position == 0)
            return;
        int parent = (position - 1) / 2;
        if (array[position].compareTo(array[parent]) > 0) {
            swap(position, parent);
            tickleUp(parent);
        }
    }

    private void tickleDown(int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int largest = parent;

        if (left <= lastPosition && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }
        if (right <= lastPosition && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }
        if (largest != parent) {
            swap(parent, largest);
            tickleDown(largest);
        }
    }
}   