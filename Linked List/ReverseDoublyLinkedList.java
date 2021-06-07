/*https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1*/

public static Node reverseDLL(Node  head)
{
    //edge case
    if (head == null || head.next == null) return head;

    //exchange the pointers of two nodes
    if (head.next.next == null)
    {
        Node temp = head.next;
        temp.next = head;
        head.prev = temp;
        head.next = null;
        temp.prev = null;
        return temp;
    }

    //for all other cases
    Node prev = head;
    Node curr = head;
    Node rest = head.next;

    //till we have more elements
    while (rest != null)
    {
        //move the current pointer
        curr = rest;

        //move the remaining pointer
        rest = rest.next;

        //modify the pointers to reverse
        curr.next = prev;
        prev.prev = curr;

        //move the previous pointer
        prev = curr;
    }

    //make appropriate pointers null
    head.next = null;
    curr.prev = null;
    return curr;
}