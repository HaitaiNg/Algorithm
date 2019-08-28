
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
    string key, value, number;
    Node *next;
    Node(string k, string v, int n)
    {
      key = k;
      value = v;
      number = n;
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
    int number = 0 ; //< number of elements in the hashmap

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
    void containsKey();
    void isEmpty();
    string get(string key)
    {
      int index = hashingFunction(key);
      Node *targetNode = pointerArray[index];
      if(targetNode != NULL)
      {
        while(targetNode != NULL)
        {
          cout << "K " << targetNode->key << "\n";
          cout << "KD " << targetNode->getKey() << "\n";
          cout << "V " << targetNode->value << "\n";
          cout << "VD " << targetNode->getValue() << "\n";



          if(key == targetNode->getKey())
          {
          //  cout << targetNode->getValue() << "\n";
          //  cout << targetNode->value << "\n";
            cout <<"hitting break";
            return "";
          }
          else
          {
            targetNode = targetNode->next;
          }
        }
      }
      cout << "Unable to find value associated with key";
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
            linkedListNode->setValue(value);
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
        Node *newNode = new Node(key, value, number);
        newNode->next = pointerArray[index];
        pointerArray[index] = newNode;
        number++;
        cout << "insert " << index << " " << key << " " << value;
        cout << " " << number << "\n";
     }

    void remove();
};


int main()
{
  cout << "Initializing & Creating Hash Map \n";
  CustomHashMap* object = new CustomHashMap();
  object->put("test", "this");
  object->put("123", "mock");
  object->get("123");
  object->get("test");
  return 0;
}
