
/*
 * The purpose of this class is to test the functions defined in
 * customHashMap.cpp
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
#include "createHashMap.cpp"
using namespace std;

/*
 * Name: printElementsFromFunctionReturn
 * Input: vector<string> elements
 * Descrption: Prints out the elements returned from a function
 * call in createHashMap.cpp. This function prints out the elements
 * to the console.
 */
void printElementsFromFunctionReturn(string name, vector<string> elements)
{
  cout << name << " ";
  for(auto element: elements)
  {
    cout << element << " ";
  }
  cout << "\n";
}
void print(string statement, string functionReturn)
{
  cout << statement << " " << functionReturn << "\n";
}
/*
 * Name: newTest
 * Descrption: Prints out a message indicating a new test is starting.
 */
void newTest()
{
  cout << "\n ---- Executing Test ---- \n";
}

/// -------------------------------------------------------------------------

/*
 * Description: Test constructor, put, size, keyset, values, get
 * Currently my hashing function will convert each key into its ASCII
 * equivalent, where ( key once converted to ASCII = index. The index
 * defines the position of
 * pointer to the linked list. This test validates whether the vector of pointers
 * to a linked list can successfully retrieve the popular value
 */
void comprehensiveTestOne()
{
  CustomHashMap* object = new CustomHashMap();
  object->put("123", "valueForKey123");
  object->put("132", "valueForKey132");
  object->put("231", "valueForKey231");
  object->put("213", "valueForKey213");
  object->put("312", "valueForKey312");
  object->put("321", "valueForKey321");
  print("Size : ", to_string(object->size()));
  printElementsFromFunctionReturn("Keys : ", object->keySet());
  printElementsFromFunctionReturn("Values : ", object->values());
  cout << "Test Get (123) = " << object->get("123") << "\n";
  cout << "Test Get (231) = " << object->get("213") << "\n";
}

 /*
  * Description: Test constructor, put, containsKey, containsValue, isEmpty
  */
  void comprehensiveTestTwo()
  {
    CustomHashMap* object = new CustomHashMap();
    object->put("AAAA", "winner");
    object->put("0x000", "unique");
    object->put("101011", "test");
    print("Contains Key (0x000) : 1 =", to_string(object->containsKey("0x000")));
    print("Contains Key (1111) : 0 =", to_string(object->containsKey("0x000")));
    print("Contains Value (\"unique\") : 1 =" , to_string(object->containsValue("unique")));
    print("Contains Value (\"breakers\") : 0 =", to_string(object->containsValue("breakers")));
    print("Is Empty : 0 =", to_string(object->isEmpty()));
    print("Size : ", to_string(object->size()));
    print("Clear Hash Map", " "); object->clear();
    print("Is Empty : 1 =", to_string(object->isEmpty()));
    print("Size : ", to_string(object->size()));
  }

  /*
   * Description: Test constructor, put, size, keyset, values. Instantiate
   * a hash map with (key, value). Modify one of the key's values, and
   * check that the changes are reflected in the output.
   *
   * *** FAIL (getValues returns the wrong value. After I modify a key with a new value,
   * keySet() & values() do not get updated ith the new change.
   *
   *
   */
   void comprehensiveTestThree()
   {
     CustomHashMap* object = new CustomHashMap();
     object->put("#1A4gh", "abcdefg");
     object->put("0x1A4MNP", "abcdefg");
     object->put("59JMLHO", "abcdefg");
     print("Size : ", to_string(object->size()));
     printElementsFromFunctionReturn("Keys : ", object->keySet());
     printElementsFromFunctionReturn("Values : ", object->values());
     print("Size : ", to_string(object->size()));
     print("Test Get (59JMLHO) = ", object->get("59JMLHO"));
     object->put("59JMLHO", "wxyz"); //< change the value of the key
     printElementsFromFunctionReturn("Keys : ", object->keySet());
     printElementsFromFunctionReturn("Values : ", object->values());
     print("Test Get (59JMLHO) = ", object->get("59JMLHO"));
   }


  /*
   * Description: Test constructor, put, containsKey, containsValue, remove,
   */
   void comprehensiveTestFour()
   {
     CustomHashMap* object = new CustomHashMap();
     object->put("AAAA", "winner");
     object->put("0x000", "unique");
     object->put("101011", "test");
     print("Test Get (AAAA) = ", object->get("AAAA"));
     print("Test Get (0x000) = ", object->get("0x000"));
     print("Test Get (101011) = ", object->get("101011"));
     print("Is Empty : 0 =", to_string(object->isEmpty()));
     print("Size :", to_string(object->size()));
     object->remove("AAAA");
     object->remove("0x000");
     object->remove("101011");
     print("Test Get (AAAA) = ", object->get("AAAA"));
     print("Test Get (0x000) = ", object->get("0x000"));
     print("Test Get (101011) = ", object->get("101011"));
     print("Is Empty : 0 =", to_string(object->isEmpty()));
     print("Size: ", to_string(object->size()));
     // cout << "IsEmpty : " <<
   }


int main()
{
  newTest();
  comprehensiveTestOne();
  newTest();
  comprehensiveTestTwo();
  newTest();
  comprehensiveTestThree();
  newTest();
  comprehensiveTestFour();
  return 0;
}
