// Copyright © 2019 AlgoExpert, LLC. All rights reserved.

import java.util.ArrayList;

class Program {
  static class Node{
    String name;
    ArrayList<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    // O(v + e) time | O(v) space
    public ArrayList<String> depthFirstSearch(ArrayList<String> array) {
      array.add(this.name);
      for (int i = 0; i < children.size(); i++) {
        children.get(i).depthFirstSearch(array);
      }
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
