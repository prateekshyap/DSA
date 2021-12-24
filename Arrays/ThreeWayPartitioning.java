/*https://practice.geeksforgeeks.org/problems/three-way-partitioning/1*/

//partition procedure in two iterations
class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int array[], int a, int b)
    {
        int replace = -1, move = 0;
        while (move < array.length)
        {
            if (array[move] < a)
            {
                ++replace;
                int temp = array[replace];
                array[replace] = array[move];
                array[move] = temp;
            }
            ++move;
        }
        move = replace+1;
        while (move < array.length)
        {
            if (array[move] <= b)
            {
                ++replace;
                int temp = array[replace];
                array[replace] = array[move];
                array[move] = temp;
            }
            ++move;
        }
    }
}

//two pointer approach
class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int array[], int a, int b)
    {
        if (array.length == 0) return;
        int start = 0;
        int end = array.length-1;
        int i = 0;
        while (i <= end)
        {
            if (array[i] < a)
            {
                int temp = array[start];
                array[start] = array[i];
                array[i] = temp;
                ++start; ++i;
            }
            else if (array[i] > b)
            {
                int temp = array[end];
                array[end] = array[i];
                array[i] = temp;
                --end;
            }
            else
                ++i;
        }
    }
}

