/*https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1*/

class Solution{
    Node divide(int N, Node head){
        // code here
        Node evenHead = new Node(0), oddHead = new Node(0), evenTail = evenHead, oddTail = oddHead;
        while (head != null)
        {
            if (head.data%2 == 0)
            {
                evenTail.next = head;
                evenTail = evenTail.next;
                head = head.next;
                evenTail.next = null;
            }
            else
            {
                oddTail.next = head;
                oddTail = oddTail.next;
                head = head.next;
                oddTail.next = null;
            }
        }
        if (evenHead == evenTail) return oddHead.next;
        evenHead = evenHead.next;
        if (oddHead != oddTail)
        {
            oddHead = oddHead.next;
            evenTail.next = oddHead;
        }
        return evenHead;
    }
}