/*https://practice.geeksforgeeks.org/problems/87f12e5c728d69a5322634776b54c75897d14daa/1/*/

class Solve
{
    static int countTriplets(Node head, int x) 
    { 
        //code here.
        int count = 0, currData;
        HashSet<Integer> set = new HashSet<Integer>();
        Node temp, curr = head;
        while (curr.next != null)
        {
            set = new HashSet<Integer>();
            temp = curr.next;
            set.add(temp.data);
            temp = temp.next;
            currData = x-curr.data;
            while (temp != null)
            {
                if (set.contains(currData-temp.data)) ++count;
                set.add(temp.data);
                temp = temp.next;
            }
            curr = curr.next;
        }
        return count;
    } 
}