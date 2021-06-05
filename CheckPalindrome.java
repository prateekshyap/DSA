/*https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1*/

class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        //if single node, return true
        if (head.next == null) return true;

        //find the break point and break the lists into two separate lists
        //a modified two pointer approach
        Node first = head;
        Node second = head;
        while (second.next != null)
        {
            second = second.next;
            if (second.next == null) break;
            first = first.next;
            second = second.next;
        }
        second = first.next;
        first.next = null;
        
        //if second list has only one node and it is equal to the first node of first list, return true
        if (second.next == null && head.data == second.data)
            return true;
        
        //reverse any one of the lists, here second list is reversed
        Node prev = second, curr = second, newList = second.next;
        while (newList != null)
        {
            curr = newList;
            newList = newList.next;
            curr.next = prev;
            prev = curr;
        }
        second.next = null;
        second = curr;

        /*head contains the first list and second contains the second list*/

        //till second list is exhausted
        while (second != null)
        {
            //if the values are different at some point, return false
            if (head.data != second.data)
                return false;
            head = head.next;
            second = second.next;
        }

        //if not interrupted, return true
        return true;
    }    
}