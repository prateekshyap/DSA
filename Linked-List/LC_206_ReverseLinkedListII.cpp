/*
https://leetcode.com/problems/reverse-linked-list-ii/
92. Reverse Linked List II

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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        
        ListNode* dummyHead = new ListNode(0, head);
        ListNode* ptr = head, *prevptr = dummyHead;
        int cnt = 1;
        
        while(cnt!=left)
        {
            cnt++;
            prevptr = ptr;
            ptr=ptr->next;
        }
        // cout<<prevptr->val<<"<-prevptr "<<endl;
        // cout<<ptr->val<<"<-ptrval "<<endl;
        //  cout<<cnt<<"<-cnt "<<endl;
        //Three Pointer Approach
        ListNode* prev = nullptr ;
        ListNode* curr = ptr ;
        ListNode* newp = nullptr ;
         cnt--;
        while(cnt!=right)    
        {
            cnt++;
            newp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = newp;
        }
       // cout<<newp->val<<"<-newp "<<endl;
        // cout<<prev->val<<"<-prev "<<endl;
        //  cout<<cnt<<"<-cnt "<<endl;
        
        prevptr->next = prev; //non-reverse-LL to new head of reverse LL
        ptr->next = newp;  // old head of reverse LL to non-reverse right part
        
        return dummyHead->next;
    }
    */
    
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode dummyHead = ListNode(-1, head);
        ListNode *prev = &dummyHead;
        ListNode *cur = head, * pnxt = nullptr, * cnxt = nullptr;
        
        for(int i=0; i<left-1; i++)
            prev = prev->next;
        cur = prev->next;
        for(int i=0; i<right-left; i++)
        {
            pnxt = prev->next;
            cnxt = cur->next;
            
            prev->next = cnxt;
            cur->next = cnxt->next;
            cnxt->next = pnxt;
        }
        
        return dummyHead.next;
    }
    
};