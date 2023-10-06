package com.myproject;

import com.myproject.model.Node;
import com.myproject.model.Tree;
import com.myproject.view.ConsoleView;
import com.myproject.presenter.ConsolePresenter;

public class Main {

   public static void main(String[] args) {
       Node<String> root = new Node<>("root");
       Tree<String> tree = new Tree<>(root);

       ConsolePresenter<String> presenter = new ConsolePresenter<>(tree, null);
       ConsoleView<String> view = new ConsoleView<>(presenter);
       presenter.setView(view);

       view.start();
   }
}