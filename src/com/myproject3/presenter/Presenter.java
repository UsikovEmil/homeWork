package com.myproject3.presenter;

public interface Presenter<T> {
    void onViewNode(String input);
    void onViewAllNodes();
}