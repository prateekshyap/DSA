/*https://practice.geeksforgeeks.org/problems/delete-middle-of-linked-list/1*/

class Solution {
    Node deleteMid(Node head) {
        if (head == null) return null;
        Node singleJump = head;
        Node doubleJump = head;
        Node prev = head;
        while (doubleJump!= null && doubleJump.next != null)
        {
            prev = singleJump;
            singleJump = singleJump.next;
            doubleJump = doubleJump.next.next;
        }
        prev.next = singleJump.next;
        return head;
    }
}