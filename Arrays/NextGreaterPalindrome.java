/*https://practice.geeksforgeeks.org/problems/next-higher-palindromic-number-using-the-same-set-of-digits5859/1*/

class Solution
{
    public String nextPalin(String N) 
    {
        char[] arr = N.toCharArray();
        int len = (arr.length/2)-1;
        int i = len-1;
        
        //move till the sequence is non-decreasing
        while(i >= 0 && arr[i+1] <= arr[i]) i--;
        
        //if such point exists
        if(i >= 0) {
            //swap with the next bigger element on right
            int j = len;
            while(j >= 0 && arr[j] <= arr[i]) j--;
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            
            //sort the right subarray
            int l = i + 1, r = len;
            while(l < r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
            
            //copy the first half to the second half in reverse order
            l = len;
            r = arr.length%2 == 0 ? len+1 : len+2;
            while (l >= 0)
            {
                arr[r] = arr[l];
                --l; ++r;
            }
            
            return String.valueOf(arr);
        }
        return "-1";
    }
}