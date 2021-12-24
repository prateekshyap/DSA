//////////////////////Leetcode////////////////////////
/*https://leetcode.com/problems/add-two-numbers/*/

/*Prateekshya's solution*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        //create a new list
        ListNode newHead = new ListNode(-1);

        ListNode temp = newHead;
        int carry = 0;

        //move till one of the list is exhausted
        while (temp1 != null && temp2 != null)
        {
            //add the values and the carry
            int sum = temp1.val+temp2.val+carry;

            //move the pointers
            temp1 = temp1.next;
            temp2 = temp2.next;

            //update carry for next iteration
            if (sum > 9)
            {
                sum -= 10;
                carry = 1;
            }
            else
                carry = 0;

            //add a new node with the sum to the new list
            temp.next = new ListNode(sum);

            //move
            temp = temp.next;
        }

        //if list1 is not exhausted, this will be executed
        while (temp1 != null)
        {
            int sum = temp1.val+carry;
            temp1 = temp1.next;
            if (sum > 9)
            {
                sum -= 10;
                carry = 1;
            }
            else
                carry = 0;
            temp.next = new ListNode(sum);
            temp = temp.next;
        }

        //if list2 is not exhausted, this will be executed
        while (temp2 != null)
        {
            int sum = temp2.val+carry;
            temp2 = temp2.next;
            if (sum > 9)
            {
                sum -= 10;
                carry = 1;
            }
            else
                carry = 0;
            temp.next = new ListNode(sum);
            temp = temp.next;
        }

        //if there is an extra carry, add it as a new node
        if (carry == 1)
            temp.next = new ListNode(1);

        //return
        return newHead.next;
    }
}