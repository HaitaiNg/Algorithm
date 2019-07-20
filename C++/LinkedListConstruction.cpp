using namespace std;

class Node {
  public:
    int value;
    Node* prev;
    Node* next;
    Node(int value);
};

class DoublyLinkedList {
  public:
    Node* head;
    Node* tail;

    DoublyLinkedList() {
      head = NULL;
      tail = NULL;
    }

    void setHead(Node* node) //< O(1) time | O(1) space
		{
      if(head == NULL)
			{
				head = node;
				tail = node;
				return;
			}
			insertBefore(head, node);
    }

    void setTail(Node* node) { //< O(1) time | O(1) space
      if(tail == NULL)
			{
				setHead(node);
				return;
			}
			insertAfter(tail, node);
    }

		//< O(1) time | O(1) space
    void insertBefore(Node* node, Node* nodeToInsert) {
      if(nodeToInsert == head && nodeToInsert == tail)
			{
				return;
			}
			remove(nodeToInsert);
			nodeToInsert->prev = node->prev;
			nodeToInsert->next = node;
			if(node->prev == NULL)
			{
				head = nodeToInsert;
			}
			else
			{
				node->prev->next = nodeToInsert;
			}
			node->prev = nodeToInsert;
    }

		//< O(1) time | O(1) space
    void insertAfter(Node* node, Node* nodeToInsert) {
      if(nodeToInsert == head && nodeToInsert == tail)
			{
				return;
			}
			remove(nodeToInsert);
			nodeToInsert->prev = node;
			nodeToInsert->next = node->next;
			if(node->next == NULL)
			{
				tail = nodeToInsert;
			}
			else
			{
				node->next->prev = nodeToInsert;
			}
			node->next = nodeToInsert;
    }

    void insertAtPosition(int position, Node* nodeToInsert) {
      if(position == 1)
			{
  		setHead(nodeToInsert);
  		return;
			}
			Node* node = head;
			int currentPosition = 1;
			while(node != NULL && currentPosition++ != position) node = node->next;
			if(node != NULL)
			{
  		insertBefore(node, nodeToInsert);
			}
			else
			{
  			setTail(nodeToInsert);
			}
    }

		//< O(n) time | O(1) space
    void removeNodesWithValue(int value) {
      Node* node = head;
			while(node != NULL)
			{
  			Node* nodeToRemove = node;
  			node = node->next;
  			if(nodeToRemove->value == value) remove(nodeToRemove);
			}
    }

		//< O(1) time | O(1) space
    void remove(Node* node) {
			if(node == head) head = head->next;
			if(node == tail) tail = tail->prev;
			removeNodeBindings(node);
    }

		//< O(n) time | O(1) space
    bool containsNodeWithValue(int value) {
			Node* node = head;
			while( node != NULL && node->value != value) node = node->next;
			return node != NULL;
    }

		void removeNodeBindings(Node* node)
		{
			if(node->prev != NULL) node->prev->next = node->next;
			if(node->next != NULL) node->next->prev = node->prev;
			node->prev = NULL;
			node->next = NULL;
		}

};
