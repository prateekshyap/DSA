/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
82. Remove Duplicates from Sorted List II

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
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head || !head->next) return head;
        
        ListNode* dummyHead = new ListNode(-101);
        ListNode* ptr = head, *prev = dummyHead, *cnext= nullptr;
        bool same =false;
        while(ptr)
        {
            same =false;
            cnext = ptr->next;
            while(cnext && cnext->val == ptr->val)
            {
                same = true;
                cnext->val = -102;
                cnext = cnext->next;
            }
            if(same)
                ptr->val = -102;
            ptr = ptr->next;
        }
            
         ptr = head;
        while(ptr)
        {
            cout<<ptr->val<<" ";
            ptr = ptr->next;
        }
        ptr = head;
        while(ptr)
        {
            while(ptr && ptr->val == -102)
                ptr = ptr->next;
            prev->next = ptr;
            prev = ptr;
            if(ptr)
            ptr = ptr->next;
        }
            
        return dummyHead->next;
    }//end
    */
    
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head || !head->next) return head;
        
        ListNode* dummyHead = new ListNode(0, head);
        ListNode* cur = head, *prev = dummyHead, *cnxt = nullptr;
        
        while(cur)
        {
            cnxt = cur->next;
            if(cnxt!=nullptr && cnxt->val == cur->val)
            {
                while(cnxt!=nullptr && cnxt->val == cur->val)
                {
                    cur = cur->next;
                    cnxt = cur->next;
                }
                prev->next = cnxt;
            }
            else
            {
                prev = prev->next;
            }
                
            cur=cur->next;
        }
        
        return dummyHead->next;
    }//end
};