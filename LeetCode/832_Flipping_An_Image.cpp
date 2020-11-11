class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& A) {
        //flip all 1's and 0's 
        for(int i = 0; i < A.size(); i++)
        {
            for(int j = 0; j < A[i].size(); j++)
            {
                if(A[i][j] == 1){
                    A[i][j] = 0;
                }
                else
                {
                    A[i][j] = 1; 
                }
            }
        }
        
        for(int k = 0; k < A.size(); k++)
        {
            std::reverse(A[k].begin(), A[k].end()); 
        }
        return A; 
    }
};