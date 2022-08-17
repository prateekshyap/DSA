/*
https://leetcode.com/problems/sort-list/
148. Sort List

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
    // /*
    ListNode* sortList(ListNode* head) {
        if(!head || !head->next)
            return head;
        
        ListNode* slow = head;
        ListNode* fast = head->next;
        while(fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* right = slow->next;
        slow->next = nullptr;
        
         ListNode* l = sortList(head);
         ListNode* r = sortList(right);
        
        return merge(l, r);
    }
    
//     ListNode* findMiddle(ListNode* head)
//     {
//         ListNode* slow = head;
//         ListNode* fast = head->next;
//         while(fast && fast->next){
//             slow = slow->next;
//             fast = fast->next->next;
//         }
        
//         return slow;
//     }
    
    
    ListNode* merge(ListNode* l1, ListNode *l2)
    {
        if(!l1)
            return l2;
        if(!l2)
            return l1;
        ListNode *dummyHead = new ListNode(0);
        ListNode *ptr = dummyHead;
        
        while(l1 && l2)
        {
            if(l1->val < l2->val){
                ptr->next = l1;
                l1 = l1->next;
            }
            else{
                ptr->next = l2;
                l2 = l2->next;
            }
            
            ptr = ptr->next;
        }
        
        if(l1)
        {    ptr->next = l1;
            l1 = l1->next;
        }
        else
        {
            ptr->next = l2;
            l2 = l2->next;  
        }
        
        return dummyHead->next;
    }
    
//     ListNode* merge__(ListNode* l1, ListNode *l2)
//     {
//         if(!l1)
//             return l2;
//         if(!l2)
//             return l1;
        
//         ListNode *ptr = nullptr;
        
        
//         if(l1->val < l2->val){
//             ptr = l1;
//             ptr->next = merge(l1->next, l2);
//         }
//         else{
//             ptr = l2;
//             ptr->next = merge(l1, l2->next);
//         }
        
        
//         return ptr;
//     }
    // */
   
};