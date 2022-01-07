/*https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1*/

class Solution{

    public static void rearrange(int arr[], int n){
        
        // Your code here
        int k = 0, j = n-1, max = arr[n-1]+1;

        for (int i = 0; i < n; i+=2)
            arr[i] += (arr[j--]%max)*max;
        for (int i = 1; i < n; i += 2)
            arr[i] += (arr[k++]%max)*max;
        for (int i = 0; i < n; i++)
            arr[i] /= max;
    }
    
}
