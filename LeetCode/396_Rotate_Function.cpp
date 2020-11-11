class Solution {
public:
    int maxRotateFunction(vector<int>& A) {
        
        long long ans = 0;
        for (int i = 0; i < A.size(); ++i) {
            ans += i * A[i];
        }
        long long tmp = ans, p = accumulate(A.begin(), A.end(), 0ll);
        for (int i = 1; i < A.size(); ++i) {
            tmp = tmp + p - A.size() * A[A.size() - i];
            ans = max(ans, tmp);
        }
        return ans;
        
        /*
        TIME LIMIT EXCEEDED 
        long long  max = 0; 
        for(int i = A.size() - 1; i >= 0; i--)
        {
            long long j = i; 
            long long  cap = A.size(); 
            long long total = 0; 
            while(cap--)
            {
                total += A[j]*cap; 
                j--; 
                if(j < 0) j = A.size() - 1; 
            }
            max = std::max(max, total); 
        }
        return max;  */ 
    }
};