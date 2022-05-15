package main;

import java.util.*;
import java.util.stream.Collectors;

public class Hierarchy<T> implements IHierarchy<T> {
    private Map<T, HierarchyNode<T>> data = new HashMap<>();
    private HierarchyNode<T> root;

    public Hierarchy(T element) {
        HierarchyNode<T> root = new HierarchyNode<>(element);
        this.root = root;
        this.data.put(element, root);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public void add(T element, T child) {
        HierarchyNode<T> parent = ensureExistsAndGet(element);

        if (data.containsKey(child)) {
            throw new IllegalArgumentException();
        }

        HierarchyNode<T> childNode = new HierarchyNode<>(child);
        childNode.setParent(parent);

        parent.getChildren().add(childNode);
        this.data.put(child, childNode);
    }

    @Override
    public void remove(T element) {
        HierarchyNode<T> current = ensureExistsAndGet(element);

        HierarchyNode<T> parent = current.getParent();

        if (parent == null) {
            throw new IllegalStateException();
        }

        parent.getChildren().remove(current);
        this.data.remove(element);

        List<HierarchyNode<T>> children = current.getChildren();
        children.forEach(i -> i.setParent(parent));
        parent.getChildren().addAll(children);

    }

    @Override
    public Iterable<T> getChildren(T element) {
        HierarchyNode<T> current = ensureExistsAndGet(element);

        return current
                .getChildren()
                .stream()
                .map(HierarchyNode::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public T getParent(T element) {
        HierarchyNode<T> current = ensureExistsAndGet(element);

        return current.getParent() == null ? null : current.getParent().getValue();
    }

    @Override
    public boolean contains(T element) {
        HierarchyNode<T> current = this.data.get(element);

        return current != null;
    }

    @Override
    public Iterable<T> getCommonElements(IHierarchy<T> other) {
        List<T> result = new ArrayList<>();

        for (T element : other) {
            if (this.data.containsKey(element)) {
                result.add(element);
            }
        }

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Deque<HierarchyNode<T>> deque = new ArrayDeque<>(Collections.singletonList(root));

            @Override
            public boolean hasNext() {
                return deque.size() > 0;
            }

            @Override
            public T next() {
                HierarchyNode<T> next = deque.poll();

                List<HierarchyNode<T>> children = next.getChildren();
                for (HierarchyNode<T> child : children) {
                    deque.offer(child);
                }

                return next.getValue();
            }
        };
    }



    private HierarchyNode<T> ensureExistsAndGet(T element) {
        HierarchyNode<T> current = this.data.get(element);

        if (current == null) {
            throw new IllegalArgumentException();
        }
        return current;
    }
}
