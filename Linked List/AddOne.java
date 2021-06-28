/*https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1/*/

/*Pratik's solution*/

class Solution
{
    static int i=0;
    public static Node addOne(Node head) 
    { 
        //code here.
        if(head == null)return head;
        Node cur = new Node(-1);
        int res = 0;
        if(head.next == null)
        {
            res = head.data+1;
            head.data = res%10;
            cur.data = res/10;
            if(i==0)
            {
                if(cur.data>0)
                {
                    cur.next = head;
                    head = cur;
                }
                return head;
            }
            return cur;
        }
        i++;
        res = head.data+addOne(head.next).data;
        i--;
        head.data = res%10;
        cur.data = res/10;
        if(i==0)
        {
            if(cur.data>0)
            {
                cur.next = head;
                head = cur;
            }
            return head;
        }
        return cur;
    }
}

/*Prateekshya's solution*/
//used recursion
class Solution
{
    static int carry;
    public static Node addOne(Node head) 
    {
        carry = 0; //initialize carry to 0

        //for single node
        if (head.next == null)
        {
            head.data += 1;
            if (head.data > 9)
            {
                head.data -= 10;
                Node newHead = new Node(1);
                newHead.next = head;
                return newHead;
            }
            return head;
        }

        //recursion call
        head = getNewList(head);

        //if still carry is present, add a new node and return
        if (carry > 0)
        {
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
    public static Node getNewList(Node head)
    {
        //base case
        if (head.next == null)
        {
            head.data += 1;
            head = check(head);
            return head;
        }

        /*recursion call*/
        head.next = getNewList(head.next);

        head.data += carry;
        head = check(head);
        return head;
    }
    public static Node check(Node head)
    {
        if (head.data > 9)
        {
            head.data -= 10;
            carry = 1;
        }
        else carry = 0;
        return head;
    }
}