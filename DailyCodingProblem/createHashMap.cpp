
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
// getKeys, getValues,

#include <algorithm>
#include <cstddef>
#include <iostream>
#include <set>
#include <vector>

using namespace std;

class CustomHashMap
{
public:
  // Each node will have a key, value, and a number.
  // Number is to keep track of history.
  struct Node{
    string key, value, numberOfItems;
    Node *next;
    Node(string k, string v, int n)
    {
      key = k;
      value = v;
      numberOfItems = n;
      next = NULL;
    }
    public:
      string getKey() {return key;}
      string getValue() {return value;}
      void setValue(string v) {value = v;}
      Node* getNext() {return next;}
    };



/// ------------------------------------------ \\
    // array of pointers
    Node* pointerArray[100000];
    int numberOfItems = 0 ; //< number of elements in the hashmap
    vector<string> listOfKeys;
    vector<string> listOfValues;
    /// Constructor: Intialize and set all indices set to NULL
    CustomHashMap()
    {
      cout << "Initializing & Creating Hash Map \n";
      for(int i = 0; i < 100000; i++){pointerArray[i] = NULL;}
    }

    // Hashing function (convert string to ASCII)
    // ASCII will be used as the key
    int hashingFunction(string key)
    {
	     //return (key -> ASCII -> number) // merkle tree (no duplicates)
      int index = 0;
      for(char c : key)
      {
        index += (int) c;
      }
    	return index;
    }

    void clear()
    {
      cout << "Deleting Hash Map" << "\n";
      CustomHashMap();
      numberOfItems = 0;
    };

    bool containsKey(string key)
    {
      return get(key) != "" ? true : false;
    }
    bool containsValue(string value)
    {
      return std::count(listOfValues.begin(), listOfValues.end(), value);
    }

    bool isEmpty(){ return numberOfItems == 0 ? true : false; };

    string get(string key)
    {
      int index = hashingFunction(key);
      Node *targetNode = pointerArray[index];
      if(targetNode != NULL)
      {
        while(targetNode != NULL)
        {
          cout << "Key " << targetNode->getKey() << "\n";
          cout << "Value " << targetNode->getValue() << "\n";
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

    int size()
    {
      return numberOfItems;
    }

    vector<string> values()
    {
      return listOfValues;
    }
    vector<string> keySet()
    {
      return listOfKeys;
    }

    void put(string key, string value){
       listOfKeys.push_back(key);
       listOfValues.push_back(value);
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
        Node *newNode = new Node(key, value, numberOfItems);
        newNode->next = pointerArray[index];
        pointerArray[index] = newNode;
        numberOfItems++;
        cout << "Creating Node: Index: " << index << " : Key: " << key << " : Value: " << value << "\n";
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
  CustomHashMap* object = new CustomHashMap();
  object->put("123", "mockValue");
  object->put("132", "mock");
  object->put("23123", "fuck");
  cout << object->size() << "\n";
//  object->clear();
  cout << object->isEmpty() << "\n";
  cout << object->size() << "\n";
  object->values();

  return 0;
}
