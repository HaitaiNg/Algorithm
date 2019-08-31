
/*
 * The purpose of this class is to create a custom hash map
 * without using the hash map library.
 *
 * Traits and characteristics of this data structure
 * (Key, value) : Key must be unique
 * Unordered
 * Dynamic allocation
 * O(1) access time
 * Methods that must be supported: clear; containsKey; containsValue;
 * isEmpty; get; keySet; put; remove; size; values
 *
 * This hash map will be built off an array (vector)
 * where (hashFunction(key)) = indice
 * key + hashing function -> array -> at indice (hashFunction(key))
 * pointer to linked list -> value.
 * Chaining and Linked List
 *
 * Written by Haitai Ng (20190830)
*/

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
    string key, value, number;
    Node *next;
    Node(string k, string v, int n)
    {
      key = k; value = v; number = n; next = NULL;
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

    /*
     * Constructor: Intialize and set all indices set to NULL
     */
    CustomHashMap()
    {
      cout << "Initializing & Creating Hash Map \n";
      for(int i = 0; i < 100000; i++){pointerArray[i] = NULL;}
    }

    /*
     * Name: hashingFunction
     * Input: string key
     * Output: int index
     * Descrption: Given a key, generate and return a unique index.
     * The index will be the location in the pointerArray where the
     * pointer to the Linked List will be stored.
     */
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

    /*
     * Name: clear
     * Descrption: Delete everything in the hash map. Reset all data structures
     */
    void clear()
    {
      CustomHashMap();
      numberOfItems = 0;
      listOfKeys.clear();
      listOfValues.clear();
    };

    /*
     * Name: containsKey
     * Input: string key
     * Output: boolean
     * Descrption: Given a key, return a boolean on whether
     * that particular key exists in the hash map
     */
    bool containsKey(string key)
    {
      return get(key) != "" ? true : false;
    }

    /*
     * Name: containsValue
     * Input: string value
     * Output: boolean
     * Descrption: Given a value, return a boolean on whether
     * that particular value exists in the hash map
     */
    bool containsValue(string value)
    {
      return std::count(listOfValues.begin(), listOfValues.end(), value);
    }

    /*
     * Name: isEmpty
     * Output: boolean
     * Descrption: Return the number of items (keys) in HashMap
     */
    bool isEmpty(){ return numberOfItems == 0 ? true : false; };

    /*
     * Name: get
     * Input: string key
     * Output: string
     * Descrption: Given a key, pass the key to the hashing function
     * to generate the index. Using that index, iterate through
     * the pointer array to find the corresponding value associated
     * to that key
     */
    string get(string key)
    {
      int index = hashingFunction(key);
      Node *targetNode = pointerArray[index];
      if(targetNode != NULL)
      {
        while(targetNode != NULL)
        {
          if(key == targetNode->getKey())
          {
            return targetNode->getValue();
          }
          else
          {
            targetNode = targetNode->next;
          }
        }
      }
      return "Unable to find value associated with key " + key + "\n";
    }

    /*
     * Name: size
     * Output: int
     * Descrption: Return the number of items in the hashmap
     */
    int size()
    {
      return numberOfItems;
    }

    /*
     * Name: values
     * Output: vector<string>
     * Descrption: Return a list (vector) of all values in all the hashmap
     */
    vector<string> values()
    {
      return listOfValues;
    }
    /*
     * Name: keySet
     * Output: vector<string>
     * Descrption: Return a list (vector) of all keys in all the hashmap
     */
    vector<string> keySet()
    {
      return listOfKeys;
    }

    /*
     * Name: put
     * Input: string key, string value
     * Output: string
     * Descrption: Given a key, pass the key to the hashing function
     * to generate the index. Using that index, iterate through
     * the pointer array to find the linked list where you will
     * insert and append to that list iwth the value
     */
    void put(string key, string value){
       listOfKeys.push_back(key);
       listOfValues.push_back(value);
	     int index = hashingFunction(key);
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

     /*
      * Name: remove
      * Input: string key
      * Descrption: Given a key, pass the key to the hashing function
      * to generate the index. Using that index, iterate through
      * the pointer array to find the corresponding linked list, then remove
      * that entry 
      */
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
