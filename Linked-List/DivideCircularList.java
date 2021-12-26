/*https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1*/

class gfg
{
    void splitList(circular_LinkedList list)
    {
        //if single node
        if (list.head.next == list.head)
        {
            list.head1 = list.head;
            list.head1.next = list.head1;
            list.head2 = null;
        }

        //if double node
        else if (list.head.next.next == list.head)
        {
            list.head1 = list.head;
            list.head2 = list.head.next;
            list.head1.next = list.head1;
            list.head2.next = list.head2;
        }

        //for all other cases
        else
        {
            //divide into two separate lists from the middle point
            //keep track of the previous nodes
            //a modified two pointer approach
            Node prevSlow = list.head;
            Node slow = list.head;
            Node prevFast = list.head;
            Node fast = list.head;
            boolean flag = true;
            while (fast != list.head || flag)
            {
                flag = false;
                prevSlow = slow;
                slow = slow.next;
                prevFast = fast;
                fast = fast.next;
                if (fast == list.head)
                    break;
                prevFast = fast;
                fast = fast.next;
            }

            //attach the heads and make them circular
            list.head1 = list.head;
            list.head2 = prevSlow.next;
            prevSlow.next = list.head1;
            prevFast.next = list.head2;
        }
	}
}