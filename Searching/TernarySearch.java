/*https://practice.geeksforgeeks.org/problems/3d27d4683c121c1f152ee8f41279255dc4430cf6/1/*/

class Solution{
    static int ternarySearch(int arr[], int N, int K)
    {
        return ternarySearchImpl(arr,K,0,N-1);
    }
    static int ternarySearchImpl(int[] arr, int key, int start, int end)
    {
        if (start <= end)
        {
            int first = start+((end-start)/3);
            int second = start+((2*(end-start))/3);
            if (arr[first] == key || arr[second] == key) return 1;
            if (key < arr[first]) return ternarySearchImpl(arr,key,start,first-1);
            else if (key > arr[first] && key < arr[second]) return ternarySearchImpl(arr,key,first+1,second-1);
            else if (key > arr[second]) return ternarySearchImpl(arr,key,second+1,end);
        }
        return -1;
    }
}