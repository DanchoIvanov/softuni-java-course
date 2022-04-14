package jar_of_T;

import java.util.ArrayDeque;

public class Jar<T> {

    private ArrayDeque<T> deque;

    public Jar() {
        this.deque = new ArrayDeque<>();
    }

    public void add (T element) {
        this.deque.push(element);
    }
        public T remove() {
            return this.deque.pop();
        }
    }

