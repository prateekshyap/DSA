/*https://practice.geeksforgeeks.org/problems/linked-list-of-strings-forms-a-palindrome/1*/

class GfG
{
    public static boolean compute(Node node)
    {
        int len = 0;
        StringBuffer buffer = new StringBuffer("");
        Node temp = node;
        while (temp != null)
        {
            buffer.append(temp.data);
            temp = temp.next;
        }
        len = buffer.length();
        len /= 2;
        StringBuffer half = new StringBuffer(buffer.substring(0,len));
        half.reverse();
        if (half.toString().equals(buffer.substring(buffer.length()-len))) return true;
        return false;
    }
}