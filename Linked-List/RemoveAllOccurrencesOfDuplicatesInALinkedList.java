/*https://practice.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1*/

class Solution
{
    public static Node removeAllDuplicates(Node head)
    {
        //code here
        Node temp = head, prev = head;

        //for duplication at the head node
        while (head != null && head.next != null && head.data == head.next.data)
        {
            while (temp != null && temp.data == head.data)
            {
                prev = temp;
                temp = temp.next;
            }
            head = temp;
        }

        //for duplication at other nodes
        while (temp != null)
        {
            if (temp.next != null && temp.data == temp.next.data)
            {
                while (temp != null && temp.data == prev.next.data)
                    temp = temp.next;
                prev.next = temp;
            }
            else
            {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}