
/*
 * The purpose of this class is to create a custom hash map
 * without using the hash map library
 * Traits and characteristics of this data structure
 * (Key, value) : Key must be unique
 * Unordered
 * Dynamic allocation
 * O(1) access time
 * Methods that must be supported: clear, containsKey, isEmpty, get, put,

 * This hash map will be built off an array (vector)
 * where (hashFunction(key)) = indice
 * key + hashing function -> array -> at indice (hashFunction(key))  pointer to linked list -> value
 *
 *
*/

#include <algorithm>
#include <cstddef>
#include <iostream>

using namespace std;

class CustomHashMap
{
public:
  // Each node will have a key, value, and a number.
  // Number is to keep track of history.
  struct Node{
    string key, value, size;
    Node *next;
    Node(string k, string v, int n)
    {
      key = k;
      value = v;
      size = n;
      next = NULL;
    }
    public:
      string getKey() {return key;}
      string getValue() {return value;}
      void setValue(string v) {value = v;}
      Node* getNext() {return next;}


    };

    // array of pointers
    Node* pointerArray[100000];
    int size = 0 ; //< number of elements in the hashmap

    /// Constructor: Intialize and set all indices set to NULL
    CustomHashMap()
    {
      for(int i = 0; i < 100000; i++){pointerArray[i] = NULL;}
    }

    // Hashing function (convert string to ASCII)
    // ASCII will be used as the key
    int  hashingFunction(string key)
    {
	     //return (key -> ASCII -> number) // merkle tree (no duplicates)
      int index = 0;
      for(char c : key)
      {
        index += (int) c;
      }
    	return index;
    }

    void clear();

    bool containsKey(string key)
    {
      return get(key) != "" ? true : false;
    }


    bool isEmpty(){return size == 0 ? true : false; };

    string get(string key)
    {
      int index = hashingFunction(key);
      Node *targetNode = pointerArray[index];
      if(targetNode != NULL)
      {
        while(targetNode != NULL)
        {
          cout << "K " << targetNode->key << "  " << key << "\n";
          cout << "KD " << targetNode->getKey() << "\n";
          cout << "V " << targetNode->value << "\n";
          cout << "VD " << targetNode->getValue() << "\n";
          if(key == targetNode->getKey())
          {
          //  cout << targetNode->getValue() << "\n";
          //  cout << targetNode->value << "\n";
            cout <<"hitting break" << "\n";
            return "";
          }
          else
          {
            targetNode = targetNode->next;
          }
        }
      }
      cout << "Unable to find value associated with key "  << key << "\n" ;
      return "";
    }

    void put(string key, string value){
	     int index = hashingFunction(key);
       //cout << "Position Index " << index;
       Node *linkedListNode = pointerArray[index];

       // Check to see if there is already a value associated to that index
       // If there is a node at index, then get the pointer to the linked list
       // edit the value associated with the target node
        while(linkedListNode != NULL)
        {
          // once you find the node with the same key
          if(key == linkedListNode->getKey())
          {
            cout << "SETTING THIS " << value << "\n";
            linkedListNode->setValue(value);
            cout << " GTTIN VALUE " << linkedListNode->getValue() << "\n";
            return;
          }
          else
          {
            linkedListNode = linkedListNode->next;
          }
        }
        // If there is no value associated with that index, then create a new
        // pointer and place it in the arrayPointer. The pointer at the
        // index will point to a linked list of Nodes
        Node *newNode = new Node(key, value, size);
        newNode->next = pointerArray[index];
        pointerArray[index] = newNode;
        size++;
        cout << "creating node " << index << " " << key << " " << value;
        cout << " " << size << "\n";
     }

    void remove(string key)
    {
      int index = hashingFunction(key);
      Node *linkedListNode = pointerArray[index];
      if(linkedListNode == NULL)
      {
        return;
      }
      else if(linkedListNode != NULL && key ==linkedListNode->getKey())
      {
        pointerArray[index] = linkedListNode->next;
        delete linkedListNode;
        return;
      }

      Node *temporaryNode;
      while(linkedListNode != NULL)
      {
        if(linkedListNode->next->getKey() == key)
        {
          temporaryNode = linkedListNode->next;
          linkedListNode = temporaryNode->next;
          delete temporaryNode;
          return;
        }
        linkedListNode = linkedListNode->next; 
      }
    }
};


int main()
{
  cout << "Initializing & Creating Hash Map \n";
  CustomHashMap* object = new CustomHashMap();
  object->put("mockKey", "mockValue");
  object->put("123", "mock");
  object->get("123");
  object->get("mockKey");
  object->containsKey("123");
  object->containsKey("FDFD");
  return 0;
}
