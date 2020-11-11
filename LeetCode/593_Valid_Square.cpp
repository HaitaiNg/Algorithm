class Solution {
public:
    int squareDistance(vector<int>& a, vector<int>& b)
    {
        int x = a[0] - b[0], y = a[1] - b[1]; 
        return x*x + y*y; 
    }
    
    bool validTriangle(vector<int>& p1, vector<int>& p2, vector<int>&p3)
    {
        vector<int> v = {squareDistance(p1,p2), squareDistance(p1,p3), squareDistance(p3,p2)}; 
        sort(v.begin(), v.end()); 
        return v[0] && v[0] == v[1] && v[0] + v[1] == v[2]; 
    }
    
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        return validTriangle(p1, p2, p3) && validTriangle(p4, p2, p3) && validTriangle(p1, p2, p4);
    }
};