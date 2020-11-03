// 4 ms run time 
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size() == 0) return false; 
        
        int row = 0;
        int col = matrix[0].size() - 1; 
        while(row < matrix.size() && col >= 0)
        {
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] > target) col--;
            else
            {
                row++; 
            }
        }
        return false; 
    }
};
/* Slower (8 ms run time )
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        for(int i = 0; i < matrix.size(); i++)
        {
            for(int j = 0; j < matrix[i].size(); j++)
            {
                if(matrix[i][j] == target) return true; 
            }
        }
        return false;
    }
};
*/ 