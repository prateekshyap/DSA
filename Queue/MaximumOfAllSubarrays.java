/*https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1*/

//using double ended queue
class Solution
{
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();
        int i;

        //for the first k elements
        for (i = 0; i < k; ++i)
        {
            //till the current element is greater than or equal to the front element
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast(); //remove the front
            deque.addLast(i); //add current element to front
        }

        //for rest of the elements
        for (; i < n; ++i)
        {
            //add the rear element to the queue
            result.add(arr[deque.peek()]);

            //remove rear till it exceeds the window range
            while (!deque.isEmpty() && deque.peek() <= i-k)
                deque.removeFirst();

            //remove front till the current element is greater than or equal to it
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();

            //add current element to the front
            deque.addLast(i);
        }

        //add the rear element
        result.add(arr[deque.peek()]);

        return result;
    }
}