/*https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1*/

class Compute {
    
    public void rotate(long arr[], long n)
    {
        int index = (int)n;
        long temp = arr[index-1];
        for (int i = index-2; i >= 0; --i)
            arr[i+1] = arr[i];
        arr[0] = temp;
    }
}