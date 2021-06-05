/*https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1*/

class Solution
{
    static Node merge(Node first, Node second)
    {
        Node newList = new Node(0);
        Node curr = newList;
       
        //normal merge process
        while (first != null && second != null) {
            if (first.data < second.data) {
                curr.next = first;
                first = first.next;
            }
            else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
       
        // While first is not null
        while (first != null) {
            curr.next = first;
            first = first.next;
            curr = curr.next;
        }
       
        // While second is not null
        while (second != null) {
            curr.next = second;
            second = second.next;
            curr = curr.next;
        }
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
    static Node mergeSort(Node head)
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

        //recur on first list
        Node first = mergeSort(head);

        //recur on second list
        Node second = mergeSort(breakPoint);
        
        //merge
        Node sortedList = merge(first, second);
 
        return sortedList;
    }
}