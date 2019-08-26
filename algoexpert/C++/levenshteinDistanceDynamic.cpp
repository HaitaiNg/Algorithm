using namespace std;

int levenshteinDistance(string str1, string str2) {
  string dynamicString = "";
  int numberOfDifferences = 0;
  if(str1.size() > str2.size())
  {
    numberOfDifferences = str1.size() - str2.size(); // numberOfDeletions
    string temp = str2;
    str2 = str1;
    str1 = temp;
  }

  int i = 0, j = 0;
  while( (i <= str1.size()) && (j <= str2.size() ))
  {
    if(str1[i] == str2[j])
    {
      dynamicString += str1[i];
      i++;
      j++;
    }

    if(str1[i] != str[j])
    {
      if( i < j)
      {
        dynamicString += str1[i];
        numberOfDifferences++;
        i++;
      }
      else if (j > i)
      {
        dynamicString += str2[j];
        numberOfDifferences++;
        j++;
      }
    }
  }
  return numberOfDifferences;
}
