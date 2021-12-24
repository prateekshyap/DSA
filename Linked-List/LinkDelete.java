/*https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1*/

/*Pratik's solution*/

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

/*Prateekshya's solution*/

class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        Node temp = head;
        int mCopy = M, nCopy = N;

        //till we have more nodes
        while (temp != null)
        {
            M = mCopy; N = nCopy;

            //skip m nodes
            while (M-- > 1)
            {
                //if list exhausts at any point, return
                if (temp == null) return;
                temp = temp.next;
            }

            //if list exhausted, return
            if (temp == null) return;

            //count n nodes
            Node nextList = temp.next;
            while (N-- > 0)
            {
                //if list exhausts at any point
                //delete everything after last m nodes and return
                if (nextList == null)
                {
                    temp.next = null;
                    return;
                }
                nextList = nextList.next;
            }

            //delete n nodes and move
            temp.next = nextList;
            temp = nextList;
        }
    }
}