/*https://practice.geeksforgeeks.org/problems/merge-sort-on-doubly-linked-list/1*/

class LinkedList
{
    static Node merge(Node first, Node second)
    {
        Node newList = new Node(0);
        Node curr = newList;
       
        //normal merge process
        while (first != null && second != null) {
            if (first.data < second.data) {
                curr.next = first;
                first.prev = curr;
                first = first.next;
            }
            else {
                curr.next = second;
                second.prev = curr;
                second = second.next;
            }
            curr = curr.next;
        }
       
        // While first is not null
        while (first != null) {
            curr.next = first;
            first.prev = curr;
            first = first.next;
            curr = curr.next;
        }
       
        // While second is not null
        while (second != null) {
            curr.next = second;
            second.prev = curr;
            second = second.next;
            curr = curr.next;
        }
        newList.next.prev = null;
        return newList.next;
    }
    static Node getMid(Node head)
    {
        //two pointer approach
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head)
    {
        //if zero or one node, return
        if (head == null || head.next == null)
            return head;
 
        //find the middle node
        Node mid = getMid(head);

        //find the break point
        Node breakPoint = mid.next;

        //divide into two separate lists
        mid.next = null;
        breakPoint.prev = null;

        //recur on first list
        Node first = sortDoubly(head);

        //recur on second list
        Node second = sortDoubly(breakPoint);
        
        //merge
        Node sortedList = merge(first, second);
 
        return sortedList;
    }
}