/*https://practice.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1*/

//without extra space but TLE
class Solution
{
    public Node sort(Node head)
    {
        //your code here, return the head of the sorted list
        if (head.next == null) return head;
        Node leftList = new Node(-1);
        Node rightList = new Node(-1);
        
        Node leftEnd = leftList, rightEnd = rightList, temp = null;
        boolean listChoice = true;
        while (head != null)
        {
            if (listChoice)
            {
                if (leftEnd.data == -1)
                {
                    leftList = leftEnd = head;
                }
                else
                {
                    leftEnd.next = head;
                    leftEnd = leftEnd.next;
                }
                head = head.next;
            }
            else
            {
                temp = head.next;
                if (rightEnd.data == -1)
                {
                    rightEnd = rightList  = head;
                    rightEnd.next = null;
                }
                else
                {
                    head.next = rightList;
                    rightList = head;
                }
                head = temp;
            }
            listChoice = !listChoice;
        }
        if (leftList.data < rightList.data)
        {
            leftEnd.next = rightList;
            rightEnd.next = null;
            return leftList;
        }
        Node newList = new Node(-1), newEnd = newList;
        while (leftList != null && rightList != null)
        {
            if (leftList != null && rightList != null)
            {
                if (leftList.data < rightList.data)
                {
                    newEnd.next = leftList;
                    leftList = leftList.next;
                }
                else
                {
                    newEnd.next = rightList;
                    rightList = rightList.next;
                }
                newEnd = newEnd.next;
            }
            else if (leftList != null)
            {
                newEnd.next = leftList;
                leftList = leftList.next;
                newEnd = newEnd.next;
            }
            else if(rightList != null)
            {
                newEnd.next = rightList;
                rightList = rightList.next;
                newEnd = newEnd.next;
            }
        }
        return newList.next;
    }
}


class Solution
{
    public Node sort(Node head)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        while (head != null)
        {
            pq.add(head.data);
            head = head.next;
        }
        while (!pq.isEmpty())
        {
            if (head == null)
            {
                head = new Node(pq.poll());
            }
            else
            {
                Node newNode = new Node(pq.poll());
                newNode.next = head;
                head = newNode;
            }
        }
        return head;
    }
}