import java.util.*;
class Program{

  static class Node{
    String name;
    ArrayList<Node> children = new ArrayList<Node>();

    public Node(String name)
    {
      this.name = name;
    }

  public Node addChild(String name)
  {
    Node child = new Node(name);
    children.add(child);
    return this;
  }

// O(v + e) time | O(v) space 
  public ArrayList<String> breadthFirstSearch(ArrayList<String> array)
  {
    ArrayDeque<Node> queue = new ArrayDeque<Node>();
    queue.add(this);
    while(!queue.isEmpty())
    {
      Node currentNode = queue.poll();
      array.add(currentNode.name);
      for(int i = 0; i < currentNode.children.size(); i++)
      {
        queue.add(currentNode.children.get(i));
      }
    }
    return array;
  }
}
}
