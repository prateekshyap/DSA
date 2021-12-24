/*https://practice.geeksforgeeks.org/problems/deletion-and-reverse-in-linked-list/1*/

class GFG
{
    public static Node deleteNode(Node head,int d)
    {
        Node temp = head, prev = head, tail = head;

        //move two pointers to the tail node
        while (tail.next != head) 
        {
            tail = tail.next;
            prev = prev.next;
        }

        //move one pointer to the node to be deleted
        while (temp.data != d)
        {
            prev = temp;
            temp = temp.next;
        }

        //skip if it is head or tail
        if (head == temp || tail == temp) return head;
        
        //otherwise delete
        prev.next = temp.next;
        
        return head;
    }
    public static Node reverse(Node head)
    {
        //edge case
        if (head.next == head)
            return head;

        //three pointer approach
        Node prev = head;
        Node curr = head;
        Node newList = head.next;
        boolean flag = false;

        //till we are left with new elements
        while (newList.next != head || !flag)
        {
            //set curr to new element
            curr = newList;

            //mark flag as true for the first time so that second time it will break from the loop
            if (newList.next == head) flag = true;
            
            //set new element to the next element
            newList = curr.next;

            //modify the poninter
            curr.next = prev;

            //move the previous pointer forward
            prev = curr;
        }

        //update the head
        head = prev.next;

        return head;
    }
}