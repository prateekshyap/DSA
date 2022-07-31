/*
https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

https://leetcode.com/problems/add-two-numbers-ii/
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
   
    ListNode* reverse(ListNode* l1)
    {
        ListNode* prev=nullptr, *cnxt, *cur = l1;
        while(cur)
        {
            cnxt = cur->next;
            cur->next = prev;
            prev = cur;
            cur = cnxt;
        }
        return prev;
    }
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(!l1)
            return l2;
        if(!l2)
            return l1;
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        int carry=0;;
        
        ListNode *cur = nullptr;
        
        while(l1 || l2 || carry)
        {
            if(l1)
            {
                carry+=l1->val;
                l1=l1->next;
            }
            if(l2)
            {
                carry+=l2->val;
                l2=l2->next;
            }
            ListNode* newptr = new ListNode(carry%10, cur);
            cur = newptr;
            carry = carry/10;
        }
        
        return cur;
    }
  
    ListNode* addTwoNumbers_(ListNode* l1, ListNode* l2) {
        if(!l1)
            return l2;
        if(!l2)
            return l1;
        
        int carry=0;
        stack<ListNode*> s1, s2;
        ListNode* cur = nullptr;
        
        while(l1)
        {
            s1.push(l1);
            l1 = l1->next;
        }
        while(l2)
        {
            s2.push(l2);
            l2 = l2->next;
        }
        
        while(!s1.empty() || !s2.empty() || carry)
        {
            if(!s1.empty())
            {
                carry += s1.top()->val; s1.pop();
            }
            
            if(!s2.empty())
            {
                carry += s2.top()->val; s2.pop();
            }
            ListNode* newptr = new ListNode(carry%10);
            carry = carry/10;
            newptr->next = cur; // insertion at the beg
            cur = newptr;
        }
        
        return cur;
    }//END
};