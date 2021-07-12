/*https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1*/

class Solution{
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null) return null;
        
        //move till the end of k nodes
        Node temp = head;
        while (k-- > 1)
            temp = temp.next;

        //if reached end, return the list
        if (temp.next == null) return head;

        //mark the new head
        Node newHead = temp.next;

        //separate both the parts
        temp.next = null;

        //start moving from the new head till end
        temp = newHead;
        while (temp.next != null)
            temp = temp.next;

        //attach the old head after that
        temp.next = head;
        
        return newHead;
    }
}