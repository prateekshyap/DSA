/*https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1/*/

class GFG 
{ 
    static double medianOfArrays(int m, int n, int a[], int b[]) 
    {
        // Your Code Here
        int i = 0, j = 0, len = m+n, targetIndex = (len-1)/2, elem1 = 0, elem2 = 0;

        while (targetIndex >= -1)
        {
            elem2 = elem1;
            if (i >= m) elem1 = b[j++];
            else if (j >= n) elem1 = a[i++];
            else if (a[i] <= b[j]) elem1 = a[i++];
            else elem1 = b[j++];
            --targetIndex;
        }
        if (len%2 == 0) return ((double)(elem1+elem2))/2;
        return elem2;
    }
}