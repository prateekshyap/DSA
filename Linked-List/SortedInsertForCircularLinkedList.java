/*https://practice.geeksforgeeks.org/problems/sorted-insert-for-circular-linked-list/1*/

class Solution
{
	public static Node sortedInsert(Node head,int data)
    {
        Node prev = head, temp = head;
        
        if (head.next == head)
        {
            Node newNode = new Node(data);
            newNode.next = head;
            head.next = newNode;
            if (head.data > data)
                head = newNode;
            return head;
        }
        
        while (prev.next != head)
            prev = prev.next;
        
        while (temp.data < data)
        {
            prev = temp;
            temp = temp.next;
            if (temp == head) break;
        }
        
        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
        if (data < head.data)
            head = newNode;
        return head;
    }
}