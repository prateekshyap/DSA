/*https://practice.geeksforgeeks.org/problems/sum-of-middle-elements-of-two-sorted-arrays2305/1/*/

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        int i1 = 0, i2 = 0, sum = 0, count = 0, elem1 = Math.min(ar1[0],ar2[0]), elem2 = Math.max(ar1[0],ar2[0]);
        while (count < n-1)
        {
            elem1 = elem2;
            if (i1 == n)
            {
                ++i2;
                elem2 = ar2[i2];
            }
            else if (i2 == n)
            {
                ++i1;
                elem2 = ar1[i1];
            }
            else if (ar1[i1+1] <= ar2[i2+1])
            {
                ++i1;
                elem2 = ar1[i1];
            }
            else
            {
                ++i2;
                elem2 = ar2[i2];
            }
            ++count;
        }
        //System.out.println(elem1+" "+elem2);
        return elem1+elem2;
    }
}