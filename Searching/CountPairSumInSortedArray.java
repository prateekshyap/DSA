/*https://practice.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1*/

class Solution{
    int Countpair(int a[], int n, int sum)
    {
        int l = 0, r = n-1;
        int count = 0;
        while (l < r)
        {
            if (a[l]+a[r] == sum)
            {
                ++count;
                ++l;
                --r;
            }
            else if (a[l]+a[r] < sum) ++l;
            else --r;
        }
        return count == 0 ? -1 : count;
    }
}