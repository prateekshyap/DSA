/*https://practice.geeksforgeeks.org/problems/modify-linked-list-1/1*/

class Solution {
    
    public Node modify(Node head){
        //Write your 
        if (head.next == null) return head;
        head = reverseList(head);
        Stack<Integer> stack = new Stack<Integer>();
        int n = 0;
        Node temp = head;
        while (temp != null)
        {
            ++n; temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < (n+1)/2; ++i)
        {
            stack.push(temp.data);
            temp = temp.next;
        }
        Node newList = null, newEnd = null;
        Node originalNodes = null, newTemp = null;
        if (n%2 == 1)
        {
            if (originalNodes == null)
            {
                originalNodes = new Node(stack.pop());
                newTemp = originalNodes;
            }
        }
        while (temp != null)
        {
            int data = stack.pop();
            if (newEnd == null)
            {
                newList = newEnd = new Node(temp.data-data);
            }
            else
            {
                Node newNode = new Node(temp.data-data);
                newNode.next = newList;
                newList = newNode;
            }
            temp = temp.next;
            if (originalNodes == null)
            {
                originalNodes = new Node(data);
                newTemp = originalNodes;
            }
            else
            {
                newTemp.next = new Node(data);
                newTemp = newTemp.next;
            }
        }
        newEnd.next = originalNodes;
        return newList;
    }
    
    public Node reverseList(Node head) {
        //edge case
        if (head == null || head.next == null)
            return head;

        //three pointer approach
        Node prev = head;
        Node curr = head;
        Node newList = head;

        //till we are left with new elements
        while (newList != null)
        {
            //set curr to new element
            curr = newList;

            //set new element to the next element
            newList = curr.next;

            //modify the poninter
            curr.next = prev;

            //move the previous pointer forward
            prev = curr;
        }

        //remove the loop
        head.next = null;

        //update the head
        head = curr;

        return head;
    }
}