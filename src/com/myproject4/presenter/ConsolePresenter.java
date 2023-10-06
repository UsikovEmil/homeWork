package com.myproject4.presenter;

import com.myproject4.model.FamilyTree;
import com.myproject4.model.Node;
import com.myproject4.model.Tree;
import com.myproject4.view.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConsolePresenter<T> implements Presenter<T> {
    private Tree<T> tree;
    private View<T> view;

    public ConsolePresenter(FamilyTree familyTree, View<T> view) {
        this.tree = familyTree;
        this.view = view;
    }

    @Override
    public void onViewNode(T data) {
        List<Node<T>> children = tree.getChildren(data);
        if (children != null) {
            view.showNodes(children);
        } else {
            view.showMessage("Узел с данными " + data.toString() + " не найден.");
        }
    }

    @Override
    public void onViewAllNodes() {
        List<Node<T>> nodes = sortNodesByName();
        view.showNodes(nodes);
    }

    private List<Node<T>> sortNodesByName() {
        List<Node<T>> nodes = (List<Node<T>>) tree;
        Collections.sort(nodes, Comparator.comparing(node -> node.getData().toString()));
        return nodes;
    }

    @Override
    public void onViewNode(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onViewNode'");
    }

    public void setView(ConsoleView view2) {
    }
}