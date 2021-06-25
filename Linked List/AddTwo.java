/*https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1*/

/* Add two numbers represented by linkedlist */

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        int firstCount = 0, secondCount = 0;
        Node curFirst = first, curSecond = second;
        while(curFirst!=null)
        {
            firstCount++;
            curFirst = curFirst.next;
        }
        while(curSecond!=null)
        {
            secondCount++;
            curSecond = curSecond.next;
        }
        int zeroCount = Math.abs(secondCount-firstCount);
        if(firstCount>secondCount)
        {
            while(zeroCount>0)
            {
                Node newNode = new Node(0);
                newNode.next = second;
                second = newNode;
                zeroCount--;
            }
        }
        else
        {
            while(zeroCount>0)
            {
                Node newNode = new Node(0);
                newNode.next = first;
                first = newNode;
                zeroCount--;
            }
        }
        return add(first,second,0);
    }
    
    static Node add(Node first,Node second,int pos)
    {
        Node carry = new Node(0);
        if(first.next==null && second.next==null)
        {
            first.data = first.data+second.data;
            carry.data = first.data/10;
            first.data = first.data%10;
            if(pos == 0)
            {
                if(carry.data!=0)
                {
                    carry.next = first;
                    first = carry;
                }
                return first;
            }
            return carry;
        }
        carry = add(first.next,second.next,pos+1);
        first.data = first.data+second.data+carry.data;
        carry.data = first.data/10;
        first.data = first.data%10;
        if(pos!=0)return carry;
        if(carry.data!=0)
        {
            carry.next = first;
            first = carry;
        }
        return first;
    }
}