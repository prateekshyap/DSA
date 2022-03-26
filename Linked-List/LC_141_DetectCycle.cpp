/* https://leetcode.com/problems/linked-list-cycle/
 * 141. Linked List Cycle
 */
 
 /**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        
        ListNode *slow = head, *fast=head;
        
        // if(!head || !head->next ) return false;
        // if(head->next == head) return true;
        
        while(fast && fast->next && slow)
        {
            slow = slow->next;
            fast = fast->next->next;
            if(slow == fast) return true;
        }
        
        // if(slow == fast) return true;
        // return false;
        
        if(!fast || !fast->next) return false;
        
        return true;
        
        
    }// end hasCycle
};