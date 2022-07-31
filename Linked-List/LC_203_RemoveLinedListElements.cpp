/*
https://leetcode.com/problems/remove-linked-list-elements/
203. Remove Linked List Elements

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
    ListNode* removeElements_(ListNode* head, int val) {
        ListNode dummyHead = ListNode();
        
        ListNode* cur = head, *prev = &dummyHead;
        while(cur)
        {
            if(cur->val == val)
            {
                prev->next = cur->next;
            }
            else
            {
                prev->next = cur;
                prev = prev->next;
            }
            cur=cur->next;
        }
        
        return dummyHead.next;
    }
    
     ListNode* removeElements(ListNode* head, int val) {
        
        if(!head) return head;
        
        ListNode* p = head;
        
        while(p->next != nullptr){
            if(p->next->val == val){
                p->next = p->next->next;
            }
            else{
                p=p->next;
            }
        }//while p
        
        if(head->val == val){
            head=head->next;
        }

        return head;
    }
};