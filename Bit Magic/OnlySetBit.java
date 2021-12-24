/*https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1*/

class Solution {
    static int findPosition(int N) {
        if (N == 0) return -1;
        int count = 0;
        boolean flag = false;
        int data = 1;

        //till the number exists
        while (N > 0)
        {
            //increase the position count
            ++count;

            //if the LSB is set
            if ((N&data)==1)
            {
                //for the first time make flag true
                if (!flag)
                    flag = true;

                //on the second set bit return -1
                else
                    return -1;
            }

            //right shift the number
            N >>= 1;
        }

        //return the position count
        return count;
    }
}