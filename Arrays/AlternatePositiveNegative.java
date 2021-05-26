/*https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1*/

class Solution {
    void rearrange(int arr[], int n) {
        ArrayList<Integer> negative = new ArrayList<Integer>();
        ArrayList<Integer> positive = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i)
            if (arr[i] < 0)
                negative.add(arr[i]);
            else
                positive.add(arr[i]);
        boolean flag = true;
        int f = 0, s = 0, i = 0;
        while (f < positive.size() && s < negative.size())
        {
            if (flag)
                arr[i++] = positive.get(f++);
            else
                arr[i++] = negative.get(s++);
            flag = !flag;
        }
        while (f < positive.size())
            arr[i++] = positive.get(f++);
        while (s < negative.size())
            arr[i++] = negative.get(s++);
    }
}

class Solution {
    void rearrange(int arr[], int n) {
        int i = 0, j = 0;
        while (i < n && j < n) {
        while (i < n) {
            if ((i%2 == 0 && arr[i] < 0) || (i%2 == 1 && arr[i] >= 0))
                break;
            ++i;
        }
        j = i+1;
        while (j < n) {
            if (arr[i] >= 0 && arr[j] < 0)
                break;
            else if (arr[i] < 0 && arr[j] >= 0)
                break;
            ++j;
        }
        if (i < n && j < n)
            rotate(arr,i,j);
        }
    }
    void rotate(int[] arr, int start, int end) {
        int temp = arr[end];
        for (int i = end; i > start; --i)
            arr[i] = arr[i-1];
        arr[start] = temp;
    }
}