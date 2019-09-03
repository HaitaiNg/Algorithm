class MyHashSet{
public:
	set<int> mySet;
	MyHashSet(){}
	void add(int key) {mySet.insert(key);}
	void remove(int key) {mySet.erase(key);}
	bool contains(int key) {return mySet.find(key) != mySet.end();} 
} 
