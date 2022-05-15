package solutions;

import java.util.*;

public class BinaryTree {
    private int value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int key, BinaryTree first, BinaryTree second) {
        this.value = key;
        this.left = first;
        this.right = second;
    }

    public Integer findLowestCommonAncestor(int first, int second) {
        List<Integer> firstPath = findPath(first);
        List<Integer> secondPath = findPath(second);

        int smallerSize = Math.min(firstPath.size(), secondPath.size());

        int i = 0;
        for (; i <  smallerSize; i++) {
            if (!firstPath.get(i).equals(secondPath.get(i))) {
                break;
            }
        }
        return firstPath.get(i - 1);
    }

    private List<Integer> findPath(int element) {
        List<Integer> result = new ArrayList<>();

        findNodePath(this, element, result);

        return result;
    }

    private boolean findNodePath(BinaryTree binaryTree, int element, List<Integer> currentPath) {
        if (binaryTree == null) { return false; }

        if (binaryTree.value == element) { return true; }

        currentPath.add(binaryTree.value);

        boolean leftResult = findNodePath(binaryTree.left, element, currentPath);
        if (leftResult) {
            return true;
        }

        boolean rightResult = findNodePath(binaryTree.right, element, currentPath);
        if (rightResult) {
            return true;
        }

        currentPath.remove(Integer.valueOf(binaryTree.value));
        return false;
    }


    public List<Integer> topView() {


        Map<Integer, Integer[]> offsetToValueLevel = new TreeMap<>();

        traversalTree(this, 0, 1, offsetToValueLevel);

        return getResult(offsetToValueLevel);
    }

    private List<Integer> getResult(Map<Integer, Integer[]> offsetToValueLevel) {
        List<Integer> result = new ArrayList<>();

        for (Integer[] valueLevel : offsetToValueLevel.values()) {
            result.add(valueLevel[0]);
        }

        return result;
    }

    private void traversalTree(BinaryTree binaryTree, int offset, int level, Map<Integer, Integer[]> offsetToValueLevel) {

        if (binaryTree == null) { return; }

        Integer[] currentValueLevel = offsetToValueLevel.get(offset);
        if (currentValueLevel == null || level < currentValueLevel[1]) {
            currentValueLevel = new Integer[2];
            currentValueLevel[0] = binaryTree.value;
            currentValueLevel[1] = level;
            offsetToValueLevel.put(offset, currentValueLevel);
        }

        traversalTree(binaryTree.left, offset -1, level + 1, offsetToValueLevel);
        traversalTree(binaryTree.right, offset +1, level + 1, offsetToValueLevel);

    }
}
