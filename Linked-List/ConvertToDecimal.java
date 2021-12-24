/*https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/*/

class Solution {
    int power = 1;
    public int getDecimalValue(ListNode head) {
        if (head.next == null)
            return head.val;
        int decimal = getDecimalValue(head.next);
        power <<= 1;
        decimal += head.val*power;
        return decimal;
    }
}