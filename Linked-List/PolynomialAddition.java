/*https://practice.geeksforgeeks.org/problems/polynomial-addition/1*/

class Solution
{
    public static Node addPolynomial(Node p1,Node p2)
    {
        //Add your code here.
        Node result = new Node(0,0);
        Node endRes = result;
        
        while (p1 != null || p2 != null)
        {
            if (p1 == null)
            {
                endRes.next = p2;
                break;
            }
            else if (p2 == null)
            {
                endRes.next = p1;
                break;
            }
            else if (p1.pow == p2.pow)
            {
                endRes.next = new Node(p1.coeff+p2.coeff,p1.pow);
                p1 = p1.next; p2 = p2.next;
                endRes = endRes.next;
            }
            else if (p1.pow > p2.pow)
            {
                endRes.next = new Node(p1.coeff,p1.pow);
                p1 = p1.next;
                endRes = endRes.next;
            }
            else
            {
                endRes.next = new Node(p2.coeff,p2.pow);
                p2 = p2.next;
                endRes = endRes.next;
            }
        }
        
        return result.next;
    }
}