package com.myproject4.model;

import java.util.*;

public class Tree<T> implements Iterable<Node<T>> {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public List<Node<T>> getChildren(T data) {
        return findNode(root, data).getChildren();
    }

    private Node<T> findNode(Node<T> root, T data) {
        if (root.getData().equals(data)) {
            return root;
        } else {
            for (Node<T> child : root.getChildren()) {
                Node<T> result = findNode(child, data);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }
    }

    @Override
    public Iterator<Node<T>> iterator() {
        List<Node<T>> nodes = new ArrayList<>();
        addNodes(root, nodes);
        return nodes.iterator();
    }

    private void addNodes(Node<T> node, List<Node<T>> nodes) {
        nodes.add(node);
        for (Node<T> child : node.getChildren()) {
            addNodes(child, nodes);
        }
    }
}