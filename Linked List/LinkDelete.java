/*https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1*/

class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        // your code here
        Node cur = head;
        
        int tempM = M, tempN = N;
        while(cur!=null)
        {           
            M = tempM;
            N = tempN;
            while(cur!=null && M!=1)
            {
                cur = cur.next;
                M--;
            }
            while(N!=0)
            {
                if(cur!=null && cur.next != null)
                {
                    cur.next = cur.next.next;
                    N--;
                }
                else
                {
                    break;
                }
            }
            if(cur==null || cur.next==null)break;
            cur = cur.next;
        }
    }
}