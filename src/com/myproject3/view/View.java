package com.myproject3.view;

import com.myproject5.model.Node;

import java.util.List;

public interface View<T> {
    void start();
    void showNodes(List<Node<T>> nodes);
    void showMessage(String message);
}