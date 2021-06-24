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