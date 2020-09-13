
// Time complexity is O(n+d)
// n = length of the input string
// d = the number of characters in input string alphabet
// auxiliary space is O(d) 


using namespace std;
#define NO_OF_CHARS 256

class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        if(s.size() == 0)
        {
            return 0;
        }

        int n = s.size();
        int currentLength = 1; // length of current substring
        int maxLength = 1; // result
        int previousIndex; //previous index
        int* visited = new int[sizeof(int) * NO_OF_CHARS];
        //Initialize the visited array as -1.
        // -1 is used to indicate that character has not been visited yet.
        for(int i = 0; i< NO_OF_CHARS; i++)
        {
        //mark first character as visited by sotring the index of first
        //character in a visited array
            visited[i] = -1;
            visited[s[0]] = 0;
        }

        //Start from the second character. First character is already processes
        // (currentLength and maxLength are initialized as 1, and visited[str[0] is set]
            for(int i = 1; i < n; i++)
            {
                //if the current character is not present in the already processed
                //substring or iti s notpart of the current NCRS, then do our len++
                previousIndex = visited[s[i]];
                if(previousIndex == -1 || i - currentLength > previousIndex )
                {
                    currentLength++;
                }
                  /* If the current character is present in currently
        considered NRCS, then update NRCS to start from
        the next character of the previous instance. */
                else
                {
                    /* Also, when we are changing the NRCS, we
            should also check whether length of the
            previous NRCS was greater than max_len or
            not.*/
                    if(currentLength > maxLength)
                    {
                        maxLength = currentLength;
                    }
                    currentLength = i - previousIndex;
                }
                // update the index of current character
                visited[s[i]] = i;
            }

           // Compare the length of last NRCS with max_len and
        // update max_len if needed
        if(currentLength > maxLength)
        {
            maxLength = currentLength;
        }

        return maxLength;
    }
};


// Driver code
int main()
{
    string str = "ABDEFGABEF";

    cout << "The input string is " << str << endl;

    int len = longestUniqueSubsttr(str);

    cout << "The length of the longest non-repeating "
            "character substring is "
        << len;
    return 0;
}
