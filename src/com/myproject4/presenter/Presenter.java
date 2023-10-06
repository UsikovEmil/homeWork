package com.myproject4.presenter;

public interface Presenter<T> {
    void onViewNode(String input);
    void onViewAllNodes();
}