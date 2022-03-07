/*https://practice.geeksforgeeks.org/problems/you-and-your-books/1*/

class Solution
{
    int max_Books(int a[], int n, int k)
    {
        // Your code here  
        int maxBooks = 0, currBooks = 0;
        int i = 0;
        while (i < n)
        {
            if (a[i] <= k) currBooks += a[i];
            else
            {
                maxBooks = Math.max(maxBooks,currBooks);
                currBooks = 0;
            }
            ++i;
        }
        maxBooks = Math.max(maxBooks,currBooks);
        return maxBooks;
    }
}