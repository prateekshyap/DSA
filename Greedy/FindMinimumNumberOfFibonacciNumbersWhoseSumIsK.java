/*https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/*/

class Solution {
    public int findMinFibonacciNumbers(int k) {
    
        //under 10^9 fibonacciNumber setting;
        //for 46 -> 1 greedy

        int result = 0;
        int sum = 0;
        int i = 2;
        int[] arr = new int[46];

        arr[0] = 1;
        arr[1] = 1;

        while(arr[i-2] + arr[i -1] <= k) {
            arr[i] = arr[i-2] + arr[i-1];
            i++;
        }

        for(int j = i - 1; j >= 0 && sum < k; j--) {
            if(sum + arr[j] <= k) {
                sum += arr[j];
                result++;
            }
        }

        return result;
    }
}

class Solution {
    public int findMinFibonacciNumbers(int k) {
        if (k < 2) return k;
        int a = 1, b = 1;
        while (b <= k) {
            b += a;
            a = b - a;
        }
        return 1 + findMinFibonacciNumbers(k - a);
    }
}