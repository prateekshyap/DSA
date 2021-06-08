/*https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1*/

class GfG{
    public long multiplyTwoLists(Node l1,Node l2){
        long n1 = 0;
        long n2 = 0;
        while(l1!=null){
            n1 = (n1*10+l1.data)%1000000007;
            l1 = l1.next;
        }
        while(l2!=null){
            n2 = (n2*10+l2.data)%1000000007;
            l2 = l2.next;
        }
        return (n1*n2)%1000000007;
    }
}