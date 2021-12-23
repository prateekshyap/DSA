/*https://practice.geeksforgeeks.org/problems/given-a-linked-list-reverse-alternate-nodes-and-append-at-the-end/*/

class Solution
{
    public static void rearrange(Node odd)
    {
        Node temp = odd, tail = odd, reverseList = new Node(1), reverseTail = reverseList;
        
        //detach the alternate nodes
        while (temp != null && temp.next != null)
        {
            reverseTail.next = temp.next;
            tail = temp;
            temp.next = temp.next.next;
            reverseTail = reverseTail.next;
            reverseTail.next = null;
            temp = temp.next;
        }
        
        reverseList = reverseList.next;
        reverseList = reverseLinkedList(reverseList); //call reverse list function
        if (tail.next != null) tail = tail.next; //move tail
        tail.next = reverseList; //attach
    }
    
    public static Node reverseLinkedList(Node head) {
        //edge case
        if (head == null || head.next == null)
            return head;

        //recursion call
        head = reverse(head);
        return head;
    }
    public static Node reverse(Node head) {
        //last node will be the base case, return it as it is
        if (head.next == null)
            return head;

        /*recursion*/
        Node newHead = reverse(head.next);
        
        //reverse
        head.next.next = head;
        head.next = null;
        
        //return
        return newHead;
    }
}
