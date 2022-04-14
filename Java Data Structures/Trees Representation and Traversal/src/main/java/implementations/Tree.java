package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {
    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... children) {
        this.value = value;
        this.children = new ArrayList<>();

        for (Tree<E> child : children) {
            this.addChild(child);
            child.setParent(this);
        }
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.value;
    }

    @Override
    public String getAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        dfs(this, stringBuilder, 0);

        return stringBuilder.toString().trim();
    }


    private void dfs(Tree<E> tree, StringBuilder stringBuilder, int whiteSpaces) {
        for (int i = 0; i < whiteSpaces; i++) {
            stringBuilder
                    .append(" ");

        }
        stringBuilder
                .append(tree.value)
                .append(System.lineSeparator());

        for (Tree<E> child : tree.children) {
            dfs(child, stringBuilder, whiteSpaces + 2);
        }
    }

    @Override
    public List<E> getLeafKeys() {

        List<E> leafNodes = new ArrayList<>();

        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.push(this);

        while (!queue.isEmpty()) {
            Tree<E> current = queue.poll();

            if (current.children.isEmpty()) {
                leafNodes.add(current.value);
            }

            for (Tree<E> child : current.children) {
                queue.push(child);
            }
        }

        return leafNodes;

    }

    @Override
    public List<E> getMiddleKeys() {


        List<E> middleNodes = new ArrayList<>();

        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.push(this);

        while (!queue.isEmpty()) {
            Tree<E> current = queue.poll();

            if (!current.children.isEmpty() && current.parent != null) {
                middleNodes.add(current.value);
            }

            for (Tree<E> child : current.children) {
                queue.push(child);
            }
        }

        return middleNodes;
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        List<Tree<E>> leafNodes = findLeafs();
        int maxSteps = 0;
        Tree<E> deepestLefMostNode = null;

        for (Tree<E> leafNode : leafNodes) {
            Tree<E> current = leafNode;
            int steps = 0;
            while (current.parent != null) {
                steps++;
                current = current.parent;
            }
            if (steps > maxSteps) {
                maxSteps = steps;
                deepestLefMostNode = leafNode;
            }
        }
        return deepestLefMostNode;
    }

    private List<Tree<E>> findLeafs() {

        List<Tree<E>> leafNodes = new ArrayList<>();

        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> current = queue.poll();

            if (current.children.isEmpty()) {
                leafNodes.add(current);
            }

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }

        return leafNodes;
    }


    @Override
    public List<E> getLongestPath() {

        Tree<E> deepestLefMostNode = getDeepestLeftmostNode();

        List<E> longestPath = new ArrayList<>();
        longestPath.add(deepestLefMostNode.value);

        while (deepestLefMostNode.parent != null) {
            longestPath.add(deepestLefMostNode.getParent().getKey());
            deepestLefMostNode= deepestLefMostNode.getParent();
        }

        Collections.reverse(longestPath);

        return longestPath;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {

        List<List<E>> pathsWithGivenSum = new ArrayList<>();

        List<Tree<E>> leafNodes = findLeafs();

        for (Tree<E> leafNode : leafNodes) {
            int currentSum = (int)leafNode.value;

            List<E> path = new ArrayList<>();
            path.add(leafNode.value);

            while (leafNode.parent != null) {
                currentSum += (int)leafNode.getParent().getKey();
                path.add(leafNode.getParent().getKey());
                leafNode = leafNode.getParent();
            }

            if (currentSum == sum) {
                Collections.reverse(path);
                pathsWithGivenSum.add(path);
            }

        }

        return pathsWithGivenSum;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        List<Tree<E>> subTreesWithGivenSum = new ArrayList<>();

        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> current = queue.poll();
            int currentSum = (int)current.getKey();

            while (!current.children.isEmpty()) {
                for (Tree<E> child : current.children) {
                    currentSum += (int) child.getKey();
                    queue.offer(child);
                }

                if (currentSum == sum) {
                    subTreesWithGivenSum.add(current);
                }
                for (Tree<E> child : current.children) {
                    current = child;
                }
            }
        }
        return subTreesWithGivenSum;
    }

    //@Override
    public List<Tree<E>> subTreesWithGivenSumDFS(int sum) {

        Map<Integer, List<Tree<E>>> sums = new HashMap<>();

        dfsSum(this, sums);

        return sums.get(sum);
    }

    private int dfsSum(Tree<E> node, Map<Integer, List<Tree<E>>> sums) {
        int sum = (int)node.getKey();

        for (Tree<E> child : node.children) {
            sum += dfsSum(child, sums);
        }

        sums.putIfAbsent(sum, new ArrayList<>());
        sums.get(sum).add(node);

        return sum;
    }
}



