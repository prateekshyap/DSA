/*https://practice.geeksforgeeks.org/problems/decimal-equivalent-of-binary-linked-list/1*/

class gfg
{
   long DecimalValue(Node head)
   {
       int mod = 1000000007;
       Node temp = head;
       long result = 0;
       while (temp != null)
       {
           result = (result*2)%mod;
           result += temp.data;
           temp = temp.next;
       }
       return result;
   }
}