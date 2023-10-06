package com.myproject6.presenter;

public interface Presenter<T> {
    void onViewNode(String input);
    void onViewAllNodes();
}