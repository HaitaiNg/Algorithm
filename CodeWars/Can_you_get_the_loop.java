import java.util.*; 

public class LoopInspector {

  public int loopSize(Node node) {
    HashMap<Node, Integer> listOfNodes = new HashMap<Node, Integer>(); 

    Node currentNode = node;
    int position = 1; 
    int positionOfLoop = -1; 
    while(currentNode != null)
    {
      if(listOfNodes.containsKey(currentNode))
      {
        positionOfLoop = listOfNodes.get(currentNode); 
        System.out.println(positionOfLoop); 
        break;
      }
      else
      {
      listOfNodes.put(currentNode, position); 
   
      }
      position++;
      currentNode = currentNode.getNext(); 
    }
    
    int max = -1; 
    for(Node x: listOfNodes.keySet())
    {
      if(listOfNodes.get(x) > max) max = listOfNodes.get(x); 
    }
    
    return max - positionOfLoop + 1; 
  }

}
