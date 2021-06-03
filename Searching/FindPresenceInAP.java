/*https://practice.geeksforgeeks.org/problems/arithmetic-number2815/1*/

class Solution{
    static int inSequence(int A, int B, int C){
        //if it is the first term itself
        if (A == B) return 1;

        //if difference is zero
        if (C == 0) return 0;

        int resInt = (int)((B-A)/C);
        double resDouble = (double)(B-A)/C;

        //if the values are equal and greater than zero, return true
        if (resInt == resDouble && resInt > 0)
            return 1;
        return 0;
    }
}