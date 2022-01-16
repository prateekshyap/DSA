/*https://practice.geeksforgeeks.org/problems/length-of-longest-palindrome-in-linked-list/1/*/

class GfG
{
    public static int maxPalindrome(Node head)
    {
      //add code here.
        if (head == null) return 0; //return 0 if list is empty
        if (head.next == null) return 1; //return 1 for single node
        int currLen = 0, maxLen = 1; //initialize variables
        ArrayList<Integer> list = new ArrayList<Integer>(); //create a stack type structure
        int tracker = -1; //this will keep track of the index to compare with current value to check for palindrome
        
        if (head.data == head.next.data) maxLen = 2; //set maxLen to 2 if head and next node are same
        list.add(head.data); list.add(head.next.data); //add the first two nodes to list
        Node temp = head.next.next; //mode temp to the 3rd node
        tracker = 1; //set tracker to 1
       
        while (temp != null) //until the list is exhausted
        {
            if (currLen == 0) //if we are going to start a brand new palindrome
            {
                if (tracker >= 0 && temp.data == (Integer)list.get(tracker)) //if current node is equal to the last inserted node in the list
                {
                    currLen = 2; //palindrome is of even length
                    --tracker; //decrease tracker for next comparison
                }
                else if (tracker >= 0 && temp.data == (Integer)list.get(tracker-1)) //if current node is equal to the penultimate node in the list
                {
                    currLen = 3; //palindrome is of odd length
                    tracker -= 2; //decrease tracker by 2 for next comparison
                }
                else //in all other cases
                {
                    tracker = list.size(); //reset tracker to extreme right position
                }
                list.add(temp.data); //add the current node to the list
                temp = temp.next; //move pointer to next node
            }
            else //if there is an ongoing palindrome
            {
                if (tracker >= 0 && temp.data == (Integer)list.get(tracker)) //if current node is equal to the last inserted node in the list
                {
                    currLen += 2; //increase the length by 2
                    list.add(temp.data); //add the current node to the list
                    --tracker; //decrease tracker for next comparison
                    temp = temp.next;
                }
                else //this is the case of termination of an ongoing palindrome
                {
                    maxLen = Math.max(maxLen,currLen); //update the maximum length
                    currLen = 0; //reset current length
                    tracker = list.size()-1; //reset tracker
                }
            }
        }
        maxLen = Math.max(maxLen,currLen); //update maximum length if the palindrome lies at extreme right
        return maxLen; //return maximum length
    }
}