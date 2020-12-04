//< Source: https://www.techiedelight.com/min-heap-max-heap-implementation-c/

#include <iostream>
#include <vector>
#include <algorithm>
#include <stdexcept> 
using namespace std; 

struct PriorityQueue{
  private:
    vector<int> A; 
    int parent(int index){ return (index - 1) / 2; }
    int Left(int index) {return (2*index) + 1;}
    int Right(int index) {return (2*index) + 2; }
    void heapifyDown(int index)
    {
      int left = Left(index);
      int right = Right(index); 
      int smallest = index; 
      if(left < size() && A[left] < A[index]){
        smallest = left; 
      }
      if(right < size() && A[right] < A[smallest]){
        smallest = right; 
      }
      if(smallest != index){
        swap(A[index], A[smallest]);
        heapifyDown(smallest); 
      }
    }
    void heapifyUp(int index){
      if(index && A[parent(index)] > A[index]){
        swap(A[index], A[parent(index)]); 
        heapifyDown(parent(index)); 
      }
    }
  
  public: 
    unsigned_int size() {return A.size(); }
    bool empty() {return A.size() == 0; }
    void push(int key){
      A.push_back(key);
      int index = size() - 1; 
      heapifyUp(index); 
    }
    void pop(){
      try{
        if(size() == 0) throw out_of_range("vector out of range"); 
        A[0] = A.back();
        A.pop_back(); 
        heapifyDown(0); 
      }
      catch(const out_of_range& oor){
        cout << "\n" << oor.what(); 
      }
    }

    int top()
    {
      return A.at(0); 
    }
};

int main()
{
  PriorityQueue pq; 
  pq.push(5);
  pq.push(100);
  pq.push(50);
  pq.pop();
  pq.pop();
}