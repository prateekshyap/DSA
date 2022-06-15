/* https://leetcode.com/problems/reverse-linked-list/
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 
 https://binarysearch.com/problems/Reverse-a-Linked-List
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
    ListNode* reverseList(ListNode* head) {
        return reverseListIterative(head);
        
        // return reverseListRecursive(head);
        // return reverseListRecursive2(head);
        
    }// end reverseList
    
    ListNode* reverseListIterative(ListNode* head) {
        
        if(head == nullptr || head->next == nullptr) return head;
        
        //Three Pointer Approach
        ListNode* prev = nullptr ;
        ListNode* curr = head ;
        ListNode* newp = nullptr ;
        
        while(curr)    
        {
            newp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = newp;
        }
        
        head = prev;
        
        return head;
    }// end reverseListIterative
    
    ListNode* reverseListRecursive(ListNode* p)
    {
        if(!p || !(p->next))
            return p;
        
        ListNode* t = reverseListRecursive(p->next);
        p->next->next = p;
        p->next = nullptr;
        
        return t;
        
    }// end reverseListRecursive
    
    ListNode* reverseListRecursive2(ListNode* curr, ListNode* prev = nullptr)
    {
        if(!curr) return curr;
        
        if(!curr->next)
        {
            curr->next = prev;
            return curr;
        }
         ListNode* curr_next = curr->next;
        curr->next = prev;
        return  reverseListRecursive2(curr_next, curr);
    }// end reverseListRecursive2
    
};