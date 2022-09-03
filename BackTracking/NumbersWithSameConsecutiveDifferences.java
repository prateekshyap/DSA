/*https://leetcode.com/problems/numbers-with-same-consecutive-differences/*/

//Backtracking
class Solution {
    ArrayList<Integer> result;
    public int[] numsSameConsecDiff(int n, int k) {
        result = new ArrayList<Integer>();
        for (int dig = 1; dig <= 9; ++dig)
            constructNumber(n-1,k,dig, new StringBuilder(Integer.toString(dig)));
        int[] arr = new int[result.size()];
        int i = 0;
        for (Integer val : result)
            arr[i++] = val;
        return arr;
    }
    private void constructNumber(int n, int k, int digit, StringBuilder number)
    {
        if (n == 0)
        {
            result.add(Integer.parseInt(number.toString()));
            return;
        }
        int next = digit+k;
        if (next <= 9)
        {
            number.append(next);
            constructNumber(n-1, k, next, number);
            number.delete(number.length()-1,number.length());
        }
        if (digit-k != next)
        {
            next = digit-k;
            if (next >= 0)
            {
                number.append(next);
                constructNumber(n-1, k, next, number);
                number.delete(number.length()-1,number.length());
            }
        }
    }
}

class Solution {
    ArrayList<Integer> result;
    public int[] numsSameConsecDiff(int n, int k) {
        result = new ArrayList<Integer>();
        for (int dig = 1; dig <= 9; ++dig)
            constructNumber(n-1,k,dig,dig);
        int[] arr = new int[result.size()];
        int i = 0;
        for (Integer val : result)
            arr[i++] = val;
        return arr;
    }
    private void constructNumber(int n, int k, int digit, int number)
    {
        if (n == 0)
        {
            result.add(number);
            return;
        }
        int next = digit+k;
        if (next <= 9)
        {
            number = number*10+next;
            constructNumber(n-1, k, next, number);
            number /= 10;
        }
        if (digit-k != next)
        {
            next = digit-k;
            if (next >= 0)
            {
                number = number*10+next;
                constructNumber(n-1, k, next, number);
                number /= 10;
            }
        }
    }
}

class Solution {
    ArrayList<Integer> result;
    public int[] numsSameConsecDiff(int n, int k) {
        result = new ArrayList<Integer>();
        for (int dig = 1; dig <= 9; ++dig)
            constructNumber(n-1,k,dig,dig);
        int[] arr = new int[result.size()];
        int i = 0;
        for (Integer val : result)
            arr[i++] = val;
        return arr;
    }
    private void constructNumber(int n, int k, int digit, int number)
    {
        if (n == 0)
        {
            result.add(number);
            return;
        }
        int next = digit+k;
        if (next <= 9)
            constructNumber(n-1, k, next, number*10+next);
        if (digit-k != next)
        {
            next = digit-k;
            if (next >= 0)
                constructNumber(n-1, k, next, number*10+next);
        }
    }
}

//BFS
class Solution {
    ArrayList<Integer> result;
    public int[] numsSameConsecDiff(int n, int k) {
        result = new ArrayList<Integer>();
        int number, numLen = 1, queueLen = 0, prevDig, nextDig;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int dig = 1; dig <= 9; ++dig)
            queue.add(dig);
        while (numLen < n)
        {
            ++numLen;
            queueLen = queue.size();
            while (queueLen-- > 0)
            {
                number = queue.poll();
                prevDig = number%10;
                nextDig = prevDig+k;
                if (nextDig <= 9)
                    queue.add(number*10+nextDig);
                if (nextDig != prevDig-k)
                {
                    nextDig = prevDig-k;
                    if (nextDig >= 0)
                        queue.add(number*10+nextDig);
                }
            }
        }
        int[] arr = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty())
            arr[i++] = queue.poll();
        return arr;
    }
}