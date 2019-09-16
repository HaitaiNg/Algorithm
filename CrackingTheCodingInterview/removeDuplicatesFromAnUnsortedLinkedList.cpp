#include <iostream>
#include <algorithm>

class Node
{
	public:
		Node* next;	
		int data; 
};

using namespace std; 

class LinkedList
{
	public: 
	int length;
	Node* head; 

	LinkedList(); //< constructor 
	~LinkedList(); //< destructor 
	void add(int data); 
	void print();
}

LinkedList::LinkedList()
{
	this->length = 0;
	this->head = NULL;
}

LinkedList::~LinkedList()
{
	std::cout<< "LIST DELETED"; 
}

void LinkedList::add(int data)
{
	Node* node = new Node();
	node->data = data; 
	node->next = this->head;
	this->head = node; 
	this->length++;
} 

void LinkedList::print()
{
	Node* head = this->head;
	int i = 1;
	while(head)
	{
		std::cout << i < " : " << head->data << endl; 
		head = head->next;
		i++;
	}
} 

int main()
{
	return 0;
}
