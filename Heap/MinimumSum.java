/*https://practice.geeksforgeeks.org/problems/minimum-sum4058/1/*/

class Solution {
    String solve(int[] arr, int n) {
        //build a minheap and two lists
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < n; ++i)
            minHeap.add(arr[i]);
        ArrayList<Integer> small = new ArrayList<Integer>();
        ArrayList<Integer> large = new ArrayList<Integer>();
        boolean swap = true; //acts as a switch

        //till we have more elements
        while (!minHeap.isEmpty())
        {
            //add the digits alternatively to both the lists
            int digit = minHeap.poll();
            if (digit == 0) continue;
            if (swap)
                small.add(0,digit);
            else
                large.add(0,digit);
            swap = !swap;
        }

        //build another list
        ArrayList<Integer> sumList = new ArrayList<Integer>();

        //store the size of the smaller list as the loop length
        int len = small.size() < large.size() ? small.size() : large.size();
        
        //to hold the carry digit
        int carry = 0;

        //for all digits
        for (int i = 0; i < len; ++i)
        {
            //store carry in sum and reset carry
            int sum = carry;
            carry = 0;

            //add LSB from both the lists
            sum += small.get(i);
            sum += large.get(i);

            //set the sum and carry
            while (sum > 9)
            {
                sum -= 10;
                carry += 1;
            }

            //add the sum to the list
            sumList.add(sum);
        }

        //if the list sizes are not equal then add the MSB of the longer list to the sum list
        if (small.size() != large.size())
            sumList.add(small.size() > large.size() ? small.get(small.size()-1)+carry : large.get(large.size()-1)+carry);
        
        //otherwise if carry is present then add only carry
        else if (carry > 0)
            sumList.add(carry);

        //append the digits to a string and return
        StringBuilder sb = new StringBuilder();
        for (int i = sumList.size()-1; i >= 0; --i)
            sb.append(sumList.get(i));
        return new String(sb);
    }
}