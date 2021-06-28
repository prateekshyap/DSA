/*https://practice.geeksforgeeks.org/problems/plus-one/1/*/

class Solution {
    static int carry;
    static ArrayList<Integer> check(ArrayList<Integer> arr, int i)
    {
        if (arr.get(i) > 9)
        {
            carry = 1;
            arr.set(i,arr.get(i)-10);
        }
        else
            carry = 0;
        return arr;
    }
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        carry = 0; //initialize carry to 0

        //add one
        arr.set(N-1,(Integer)arr.get(N-1)+1);

        //check for carry
        arr = check(arr,N-1);

        //if no carry, return
        if (carry == 0) return arr;

        //if carry present but single digit number
        if (N == 1) {
            arr.add(0,carry);
            return arr;
        }

        //otherwise run a reverse loop
        int i = N-2;
        while (i >= 0)
        {
            //break when carry becomes 0
            if (carry == 0) break;

            //add carry
            arr.set(i,(Integer)arr.get(i)+carry);

            //check for next carry
            arr = check(arr,i);

            --i;
        }

        //if still carry present, add it and return
        if (carry == 1)
            arr.add(0,1);
        return arr;
    }
}