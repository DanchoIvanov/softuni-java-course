package implementations;

import java.util.Iterator;

public class ReversedList <E> implements Iterable<E> {
    private final int INITIAL_CAPACITY = 2;
    private int size;
    private int tail;
    private Object[] elements;

    public ReversedList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    public void add(E element) {
        if (this.size == 0) {
            this.elements[tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                this.elements = grow();
            }
            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.elements.length;
    }

    public E get(int index) {
        ensureInBounds(index);
        return this.getAt(this.size - (index + 1));
    }

    public E removeAt(int index) {
        ensureInBounds(index);

        E element = this.get(index);

        index = this.size - (index +1);

        for (int i = index; i < this.size -1; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[this.size -1] = null;

        this.size--;
        this.tail--;

        return element;
    }

    private void ensureInBounds(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2;

        Object[] newElements = new Object[newCapacity];

        if (this.tail + 1 >= 0) System.arraycopy(this.elements, 0, newElements, 0, this.tail + 1);

        return newElements;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private E getAt(int index) {
        return (E) this.elements[index];
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = size - 1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return getAt(index--);
            }
        };
    }
}
