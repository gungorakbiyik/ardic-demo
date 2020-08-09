package com.gun.ardic.demo.binarytree;

import org.springframework.util.StopWatch;

import java.util.HashSet;

public class BinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean findAnomaly() {
        StopWatch sw = new StopWatch();
        sw.start();
        HashSet<Integer> keys = new HashSet<>();
        boolean retVal = checkAnomally(keys, root);
        sw.stop();
        System.out.println(String.format("Elapsed: %s ms.", sw.getTotalTimeMillis()));
        return retVal;
    }

    private boolean checkAnomally(HashSet<Integer> keys, Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return false;
        }

        if (node.getLeft() != null) {
            if (keys.contains(node.getLeft().getValue())) {
                return true;
            }
            keys.add(node.getLeft().getValue());
        }


        if (node.getRight() != null) {
            if (keys.contains(node.getRight().getValue())) {
                return true;
            }
            keys.add(node.getRight().getValue());
        }

        return checkAnomally(keys, node.getLeft()) || checkAnomally(keys, node.getRight());
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
