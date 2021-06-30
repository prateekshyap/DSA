/*https://practice.geeksforgeeks.org/problems/intersection-of-two-linked-list/1*/

class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        HashSet<Integer> set = new HashSet<Integer>();

        //add second list to hashset
        while (head2 != null)
        {
            set.add(head2.data);
            head2 = head2.next;
        }

        //move till the first intersection point
        Node prev = head1;
        while (!set.contains(head1.data))
        {
            prev = head1;
            head1 = head1.next;
        }

        //move till the end of first list
        Node temp = head1;
        while (temp != null)
        {
        	//if intersection then move
            if (set.contains(temp.data))
            {
                prev = temp;
                temp = temp.next;
            }

            //otherwise delete
            else
            {
                prev.next = temp.next;
                temp = prev.next;
            }
        }
        return head1;
    }
}