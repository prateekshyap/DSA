/* https://leetcode.com/problems/remove-linked-list-elements/
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.the reversed list.
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
    ListNode* removeElements(ListNode* head, int val) {
        
        if(head == nullptr) return head;
        
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