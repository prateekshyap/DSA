/*https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1*/

class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node zeroHead = new Node(0);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(0);
        Node oneTail = oneHead;
        Node twoHead = new Node(0);
        Node twoTail = twoHead;

        //keep moving the head
        while (head != null)
        {
            //keep adding new nodes to the respective lists
            if (head.data == 0)
            {
                zeroTail.next = new Node(0);
                zeroTail = zeroTail.next;
            }
            else if (head.data == 1)
            {
                oneTail.next = new Node(1);
                oneTail = oneTail.next;
            }
            else
            {
                twoTail.next = new Node(2);
                twoTail = twoTail.next;
            }
            head = head.next;
        }

        //attach the lists and return
        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
            oneTail.next = twoHead.next;
            return zeroHead.next;
        }
        zeroTail.next = twoHead.next;
        return zeroHead.next;
    }
}