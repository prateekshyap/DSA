/*https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1*/

class Solution
{
    public static void removeLoop(Node head){
        Node slow=head;
        Node fast=head;

        //edge cases
        if(head == null || head.next == null || head.next.next == null)
            return;

        //two pointer approach
        slow = head.next;
        fast = head.next.next;
        Node del = slow; //it runs one node behind the fast pointer
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            del = del.next.next;
            if(slow == fast)
            {
                break;
            }
        }

        //if the cycle starts at the head
        if (slow == head && fast == head)
        {
            del.next = null;
        }

        //in other cases
        else if (fast != null && slow == fast)
        {
        	//locate the loop
        	//del runs one node behind the fast pointer
            slow = head;
            while (slow != fast)
            {
                slow = slow.next;
                fast = fast.next;
                del = del.next;
            }

            //remove the cycle
            del.next = null;
        }
    }
}