/* https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
* or
* https://leetcode.com/problems/add-two-numbers-ii/ */


/* Pratik's solution */

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

/*Prateekshya's solution*/

class Solution{
    static int carry;
    static Node addTwoLists(Node first, Node second){
        carry = 0;

        //count nodes
        int n1 = countNodes(first);
        int n2 = countNodes(second);
        
        //create the zero list to fill the gap
        int loop = Math.abs(n1-n2);
        Node zeroHead = new Node(0);
        Node temp = zeroHead;
        while (loop-- > 0)
        {
            temp.next = new Node(0);
            temp = temp.next;
        }
        zeroHead = zeroHead.next;

        //attach it to the smaller list
        if (n1 < n2)
        {
            temp.next = first;
            first = zeroHead;
        }
        else if (n1 > n2)
        {
            temp.next = second;
            second = zeroHead;
        }

        //recursion call
        Node sumList = add(first, second);

        //check for carry and return
        if (carry > 0)
        {
            Node newNode = new Node(carry);
            newNode.next = sumList;
            sumList = newNode;
        }
        return sumList;
    }
    static Node add(Node first, Node second)
    {
        //base case
        if (first.next == null && second.next == null)
        {
            Node newNode = new Node(first.data+second.data);
            newNode = check(newNode);
            return newNode;
        }
        /*recursion*/
        Node addedList = add(first.next, second.next);
        
        //add
        Node newNode = new Node(first.data+second.data);
        newNode.data += carry;
        
        //check
        newNode = check(newNode);
        
        //attach and return
        newNode.next = addedList;
        return newNode;
    }
    static int countNodes(Node head)
    {
        int n = 0;
        Node temp = head;
        while (temp != null)
        {
            ++n;
            temp = temp.next;
        }
        return n;
    }
    static Node check(Node head)
    {
        if (head.data > 9)
        {
            carry = 1;
            head.data -= 10;
        }
        else carry = 0;
        return head;
    }
}