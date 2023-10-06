package com.myproject6;

import com.myproject6.model.Node;
import com.myproject6.model.Tree;
import com.myproject6.view.ConsoleView;
import com.myproject6.presenter.ConsolePresenter;

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