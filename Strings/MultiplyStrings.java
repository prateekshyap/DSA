/*https://leetcode.com/problems/multiply-strings*/

/*Prateekshya*/

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
    }
}

class LL
{
    public Node head, tail;
    LL()
    {
        head = new Node(-1);
        tail = head;
    }
    public void addNode(int data)
    {
        tail.next = new Node(data);
        tail = tail.next;
    }
    public void finalizeList()
    {
        head = head.next;
    }
}

class Solution
{
    public String multiply(String num1, String num2)
    {
        //base cases
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;
        
        //build two linked lists from the given strings
        LL n1 = new LL();
        for (int i = num1.length()-1; i >= 0; --i)
            n1.addNode(Integer.parseInt(Character.toString(num1.charAt(i))));
        n1.finalizeList();
        LL n2 = new LL();
        for (int i = num2.length()-1; i >= 0; --i)
            n2.addNode(Integer.parseInt(Character.toString(num2.charAt(i))));
        n2.finalizeList();
        
        //build a result list
        LL result = new LL();
        
        Node n1Iter = n1.head, n2Iter = n2.head, rPoint = result.head, rIter = result.head;
        int carry = 0;
        
        //till the second list is exhausted
        while (n2Iter != null)
        {
            //get the product and the carry
            int prod = n1Iter.data*n2Iter.data;
            prod += carry;
            carry = prod/10;
            prod %= 10;
            
            //create a new node in result list with product value
            rIter.next = new Node(prod);
            rIter = rIter.next;
            
            //move second list pointer
            n2Iter = n2Iter.next;
        }

        //if still carry is there
        while (carry > 0)
        {
            //keep adding new nodes till carry is exhausted
            rIter.next = new Node(carry%10);
            rIter = rIter.next;
            carry /= 10;
        }
        
        //set the pointers
        result.finalizeList();
        rPoint = result.head.next;
        rIter = result.head;
        n1Iter = n1Iter.next;
        n2Iter = n2.head;
        
        //till the first list is exhausted
        while (n1Iter != null)
        {
            carry = 0;

            //till the second list is exhausted
            while (n2Iter != null)
            {
                //get the product and the carry
                int prod = n1Iter.data*n2Iter.data;
                prod += carry;

                //add product to the result list at its appropriate position
                if (rIter.next == null)
                {
                    carry = prod/10;
                    prod %= 10;
                    rIter.next = new Node(prod);
                    rIter = rIter.next;
                    if (rPoint == null) rPoint = rIter;
                }
                else
                {
                    rIter = rIter.next;
                    rIter.data += prod;
                    carry = rIter.data/10;
                    rIter.data %= 10;
                }

                //move the second list pointer
                n2Iter = n2Iter.next;
            }

            //if still carry is there
            while (carry > 0)
            {
                //keep adding carry till exhausted
                if (rIter.next == null)
                {
                    rIter.next = new Node(carry%10);
                    rIter = rIter.next;
                    if (rPoint == null) rPoint = rIter;
                }
                else
                {
                    rIter = rIter.next;
                    rIter.data += carry;
                }
                carry /= 10;
            }

            //set all the pointers
            n2Iter = n2.head;
            n1Iter = n1Iter.next;
            rIter = rPoint;
            rPoint = rPoint.next;
        }

        //convert the linkedlist to string
        StringBuffer res = new StringBuffer("");
        rIter = result.head;
        while (rIter != null)
        {
            StringBuffer temp = new StringBuffer(Integer.toString(rIter.data));
            temp.append(res);
            res = temp;
            rIter = rIter.next;
        }

        return new String(res);
    }
}

/*Efficient solution*/

class Solution {
    public String multiply(String num1, String num2) {
        
        //base cases
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        //create array
        int[] temp = new int[num1.length() + num2.length() - 1];
        
        //convert strings to character arrays
        char[] chn1 = num1.toCharArray();
        char[] chn2 = num2.toCharArray();
        
        //for all digits of 1st number in reverse order
        for (int i = chn1.length - 1; i >= 0; i--) {

            //for all digits of 2nd number in reverse order
            for (int j = chn2.length - 1; j >= 0; j--) {

                //mulitply and add to the proper position
                temp[i + j] += (chn1[i] - '0')*(chn2[j] - '0');
            }
        }
        
        //set carry to 0
        int carry = 0;

        //for each position of the result in reverse order
        for (int i = temp.length - 1; i >= 0; i--) {

            //carry forward the carry part
            carry += temp[i];
            temp[i] = carry % 10;
            carry /= 10;
        }
        
        //convert to string
        StringBuilder sb = new StringBuilder();
        
        if (carry > 0) sb.append(carry);
        
        for (int t: temp) sb.append(t);
        
        return sb.toString();
    }
}

class Solution
{
    public String multiply(String num1, String num2)
    {
        if(num1.equals("0") || num2.equals("0")) return "0";
        char[] chNum1 = num1.toCharArray();
        char[] chNum2 = num2.toCharArray();
        int[] ans = new int[chNum1.length + chNum2.length - 1];
        for(int i = 0; i < chNum1.length; i++)
            for(int j = 0; j < chNum2.length; j++)
                ans[i+j] += (chNum1[i] - '0') * (chNum2[j] - '0');
        for(int i = ans.length - 1; i >= 1; i--)
        {
            ans[i-1] += ans[i] / 10;
            ans[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ans) {
            sb.append(i);
        }
        return sb.toString();
    }
}