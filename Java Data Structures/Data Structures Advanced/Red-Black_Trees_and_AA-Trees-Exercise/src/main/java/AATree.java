import java.util.function.Consumer;

class AATree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public static class Node<T extends Comparable<T>> {
        private Node<T> left;
        private Node<T> right;
        private T value;
        private int level;

        public Node(T value) {
            this.value = value;
            this.level = 1;
        }
    }

    public AATree() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
    }

    public void insert(T element) {
        this.root = this.insert(this.root, element);
        this.size++;
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (node.value.compareTo(value) > 0) {
            node.left = this.insert(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            node.right = this.insert(node.right, value);
        }

        node = skew(node);
        node = split(node);

        return node;
    }

    private Node<T> split(Node<T> node) {
        if (node.right == null || node.right.right == null) {
            return node;
        }
        if( node.right.right.level == node.level )
        {
            node = rotateWithRightChild( node );
            node.level++;
        }
        return node;
    }

    private Node<T> rotateWithRightChild(Node<T> node) {
        Node<T> result = node.right;
        node.right = result.left;
        result.left = node;

        return result;
    }

    private Node<T> skew(Node<T> node) {
        if (node.left == null) {
            return node;
        }
        if(node.left.level == node.level ) {
            node = rotateWithLeftChild(node);
        }
        return node;
    }

    private Node<T> rotateWithLeftChild(Node<T> node) {
        Node<T> result = node.left;
        node.left = result.right;
        result.right = node;

        return result;
    }

    public int countNodes() {
        return this.size;
    }

    public boolean search(T element) {
        Node<T> current = this.root;

        while (current != null) {
            int cmp = element.compareTo(current.value);

            if (cmp > 0) {
                current = current.right;
            } else if (cmp <  0) {
                current = current.left;
            } else {
                return true;
            }
        }

        return false;
    }

    public void inOrder(Consumer<T> consumer) {
        inOrder(this.root, consumer);
    }

    private void inOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        inOrder(node.left, consumer);
        consumer.accept(node.value);
        inOrder(node.right, consumer);
    }

    public void preOrder(Consumer<T> consumer) {
        preOrder(this.root, consumer);
    }

    private void preOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        consumer.accept(node.value);
        preOrder(node.left, consumer);
        preOrder(node.right, consumer);
    }

    public void postOrder(Consumer<T> consumer) {
        postOrder(this.root, consumer);
    }

    private void postOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        postOrder(node.left, consumer);
        postOrder(node.right, consumer);
        consumer.accept(node.value);
    }
}