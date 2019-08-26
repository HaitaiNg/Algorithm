#include <vector>
using namespace std;

class MinHeap{
public:
  vector<int> heap;
  MinHeap(vector<int> vector){ heap = buildHeap(&vector);}

  //O(n) time | O(1) space
  vector<int> buildHeap(vector<int>* vector)
  {
    int firstParentIndex = (vector->size() - 2)/2;
    for(int currentIndex = firstParentIndex; currentIndex >= 0; currentIndex--)
    {
      siftDown(currentIndex, vector->size() - 1, vector);
    }
    return *vector;
  }

  // O(log(n) time | O(1) space
  void siftDown(int currentIndex, int endIndex, vector<int>* heap)
  {
    int childOneIndex = currentIndex * 2 + 1;
    while(childOneIndex <= endIndex)
    {
      int childTwoIndex = currentIndex * 2 + 2 <= endIndex ? currentIndex * 2 + 2 : -1;
      int indexToSwap;
      if(childTwoIndex != -1 && heap->at(childTwoIndex) < heap->at(childOneIndex))
      {
        indexToSwap = childTwoIndex;
      }
      else
      {
        indexToSwap = childOneIndex;
      }
      if(heap->at(indexToSwap) < heap->at(currentIndex))
      {
        swap(currentIndex, indexToSwap, heap);
        currentIndex = indexToSwap;
        childOneIndex = currentIndex * 2 + 1;
      }
      else
      {
        return;
      }
    }
  }

// O(log(n)) time | O(1) space
  void siftUp(int currentIndex, vector<int>* heap)
  {
    int parentIndex = (currentIndex - 1) / 2;
    while(currentIndex > 0 && heap->at(currentIndex) < heap->at(parentIndex))
    {
      swap(currentIndex, parentIndex, heap);
      currentIndex = parentIndex;
      parentIndex = (currentIndex - 1) / 2;
    }
  }


  int peak() {return heap[0];}

  int remove()
  {
    swap(0, heap.size() - 1, &heap);
    int valueToRemove = heap.back();
    heap.pop_back();
    siftDown(0, heap.size() - 1, &heap);
    return valueToRemove;
  }

  int insert(int value)
  {
    heap.push_back(value);
    siftUp(heap.size() -1, &heap);
  }
  void swap(int i,  int j, vector<int>* heap)
  {
    int temp = heap->at(j);
    heap->at(j) = heap->at(i);
    heap->at(i) = temp;
  }
};
