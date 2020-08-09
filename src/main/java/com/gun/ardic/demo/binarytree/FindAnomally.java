package com.gun.ardic.demo.binarytree;

public class FindAnomally {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.setRoot(new Node(1, new Node(2), new Node(3)));

        bt.getRoot().getLeft().setLeft(new Node(3));
        bt.getRoot().getLeft().setRight(new Node(4));
        System.out.println(bt.findAnomaly());
    }

}
