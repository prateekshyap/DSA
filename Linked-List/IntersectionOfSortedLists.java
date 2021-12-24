/*https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1*/

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        Node prev1 = head1, prev2 = head2;

        //move both the heads till they are equal
        while (head1.data != head2.data)
        {
            if (head1.data < head2.data)
            {
                prev1 = head1;
                head1 = head1.next;
            }
            else if (head1.data > head2.data)
            {
                prev2 = head2;
                head2 = head2.next;
            }
        }

        //add more pointers
        Node temp1 = head1, temp2 = head2;

        //move the pointers till one of them becomes null
        while (temp1 != null && temp2 != null)
        {
        	//if the values are equal then move both
            if (temp1.data == temp2.data)
            {
                prev1 = temp1; temp1 = temp1.next;
                prev2 = temp2; temp2 = temp2.next;
            }

            //otherwise move the one with smaller value
            else if (temp1.data < temp2.data)
            {
                prev1.next = temp1.next;
                temp1 = prev1.next;
            }
            else
            {
                prev2.next = temp2.next;
                temp2 = prev2.next;
            }
        }

        //return the list having null at temp pointer
        if (temp1 == null) return head1;
        return head2;
    }
}