/*https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1*/

//some noob C program using hashtable
int main() {
	//code
	int testCases;
	scanf("%d",&testCases);
	int i;
    int resultArr[testCases];
    if (testCases >= 1 && testCases <= 200) {
    for (i = 0; i < testCases; ++i)
    {
        int j;
        int dim;
        scanf("%d",&dim);
        int hashArr[dim];
        if (dim >= 1 && dim <= 10000000) {
        for (j = 0; j < dim; ++j)
            hashArr[j] = 0;
        for (j = 0; j < dim-1; ++j)
        {
            int num;
            scanf("%d",&num);
            ++hashArr[num-1];
        }
        for (j = 0; j < dim; ++j)
        {
            if (hashArr[j] == 0){
                resultArr[i] = j+1;
            }
        }
        }
    }
    for (i = 0; i < testCases; ++i)
        printf("%d\n",resultArr[i]);
    }
	return 0;
}

//bit magic solution
class Solution {
    int MissingNumber(int array[], int n) {
        //xor all the numbers from 1 to n
        int xor = 1;
        for (int i = 2; i <= n; ++i)
            xor ^= i;

        //xor all the elements of the given array
        for (int i = 0; i < n-1; ++i)
            xor ^= array[i];

        //the missing element will remain
        return xor;
    }
}