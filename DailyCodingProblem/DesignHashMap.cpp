#include <vector>

using namespace std;

class MyHashMap{
	public:
		vector<int> hashMap; 
	MyHashMap(){ hashMap = std::vector<int>(100001, -1); }
	void put(int key, int value){vector[key] = value;} 
	int get(int key) {return hashMap[key];}
	void remove(int key){ hashMap[key] = -1; } 
}; 
