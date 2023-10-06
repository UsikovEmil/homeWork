package com.myproject6.presenter;

import com.myproject6.model.Node;
import com.myproject6.model.Tree;
import com.myproject6.view.ConsoleView;
import com.myproject6.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConsolePresenter<T> implements Presenter<T> {
    private Tree<T> tree;
    private View<T> view;

    public ConsolePresenter(Tree<T> tree, View<T> view) {
        this.tree = tree;
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
       List<Node<T>> nodes = new ArrayList<>();
       for (Node<T> node : tree) { // using the iterator of Tree
           nodes.add(node);
       }
       Collections.sort(nodes, Comparator.comparing(node -> node.getData().toString()));
       return nodes;
   }

public void setView(ConsoleView<String> view2) {
}

@Override
public void onViewNode(String input) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'onViewNode'");
}
}