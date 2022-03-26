/* 
 *	https://leetcode.com/problems/linked-list-cycle-ii/
 *  142. Linked List Cycle II
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
    ListNode *detectCycle(ListNode *head) {
        
        // if empty LL or single node or two node
        if(!head || !head->next || !head->next->next) return nullptr;
        
        ListNode* slow = head->next, *fast = head->next->next;
        
        while(slow && fast && fast->next)
        {
            
         if(slow == fast) break;
         slow = slow->next;
         fast = fast->next->next;
        }
        
        //if no cycle
        if(slow != fast) return nullptr;
        
        //if cycle exist, start from head node
        slow = head;
        while(slow != fast)
        {
            slow = slow->next;
            fast = fast->next;
        }
        
        return slow;
    }// end
};