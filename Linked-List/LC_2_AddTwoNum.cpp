/*
2. Add Two Numbers
https://leetcode.com/problems/add-two-numbers/
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    /*
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(!l1)
            return l2;
        if(!l2)
            return l1;
        
        ListNode *head = new ListNode();
        ListNode *ptr = head;
        int sum=0; int carry=0;
        
        while(l1 && l2)
        {
            sum = l1->val + l2->val + carry;
            carry = sum/10;
            sum = sum%10;
            l1->val = sum;
            ptr->next = l1;
            ptr = ptr->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        while(l1)
        {
            sum = l1->val + carry;
            carry = sum/10;
            sum = sum%10;
            l1->val = sum;
            ptr->next = l1;
            ptr = ptr->next;
            l1 = l1->next;
        }
        while(l2)
        {
            sum = l2->val + carry;
            carry = sum/10;
            sum = sum%10;
            l2->val = sum;
            ptr->next = l2;
            ptr = ptr->next;
            l2 = l2->next;
        }
        
        if(carry)
            ptr->next = new ListNode(carry);
        
        return head->next;;
        
    }
    */
    
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(!l1)
            return l2;
        if(!l2)
            return l1;
        
        int carry=0, sum=0;;
        
        ListNode *head = new ListNode();
        ListNode *ptr = head;
        
        while(l1 || l2 || carry)
        {
            sum = carry;
            if(l1)
            {
                sum+=l1->val;
                l1=l1->next;
            }
            if(l2)
            {
                sum+=l2->val;
                l2=l2->next;
            }
            ptr->next = new ListNode(sum%10);
            ptr = ptr->next;
            carry = sum/10;
        }
        
        return head->next;
    }
};