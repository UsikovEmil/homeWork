package com.myproject5.presenter;

public interface Presenter<T> {
    void onViewNode(String input);
    void onViewAllNodes();
}