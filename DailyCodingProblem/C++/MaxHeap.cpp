//< Source: https://www.techiedelight.com/min-heap-max-heap-implementation-c/

#include <iostream>
#include <vector> 
#include <algorithm>
#include <stdexcept> 
using namespace std; 

struct PriorityQueue{
    private:
        vector<int> A; 
        int parent(int i){return (i - 1)/2;}
        int Left(int i ){return (2*i) + 1;}
        int Right(int i ){return (2*i) + 2;}
        
        void heapifyDown(int i){
            int left = Left(i); 
            int right = Right(i); 
            int largest = i; 
            if(left < size() && A[left] > A[i]) largest = left; 
            if(right < size() && A[right] > A[largest]) largest = right; 
            if(largest != i){
                swap( A[i], A[largest]); 
                heapifyDown(largest); 
            }
        }

        void heapifyUp(int i){
            if(i && A[parent(i) < A[i]]){
                swap(A[i], A[parent(i)]); 
                heapifyUp(parent(i)); 
            }
        }

    public: 
        unsigned int size(){ return A.size();} 
        bool empty(){ return size() == 0; }
        void push(int key){
            A.push_back(key); 
            int index = size() - 1; 
            heapifyUp(index); 
        }
        void pop(){
            try{
                if(size() == 0) throw out_of_range("vector<x>::at() : index is out of range"); 
                A[0] = A.back(); 
                A.pop_back(); 
                heapifyDown(0); 
            }
            catch(const out_of_range& oor){
                cout << "\n" << oor.what(); 
            }
        }

        int top(){
            try{
                if(size() == 0) throw out_of_range("vector<x> at(): index is out of range"); 
                return A.at(0); 
            }catch (const out_of_range& oor){
                cout << "\n" << oor.what(); 
            }
        }
};

int main()
{
    PriorityQueue pq; 
    pq.push(3); pq.push(2); pq.push(15); 
    cout << "Size is " << pq.size() << endl; 
    cout << pq.top() << endl;
    pq.pop(); 
    pq.push(23); 
    pq.push(53); 
    pq.pop();
    cout << "Size is " << pq.size() << endl; 
    return 0; 
}