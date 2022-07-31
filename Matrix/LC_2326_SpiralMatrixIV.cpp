/*
https://leetcode.com/problems/spiral-matrix-iv/
2326. Spiral Matrix IV

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
    vector<vector<int>> spiralMatrix(int m, int n, ListNode* head) {
        vector<vector<int>> ans(m, vector<int>(n, -1));
        int direction=0;
        
        int left=0, right = n-1;
        int top=0, bottom = m-1;
        int r=0, c=0;
        ListNode* ptr = head;
        
        while(ptr)
        {
            if(direction==0)
            {
                for(c=left; c<=right && ptr; c++, ptr = ptr->next)
                    ans[top][c] = ptr->val;
                top++;
                direction = 1;
            }
            else if(direction == 1)
            {
                for(r=top; r<=bottom && ptr; r++, ptr = ptr->next)
                    ans[r][right] = ptr->val;
                right--;
                direction = 2;
            }
            else if(direction == 2)
            {
                for(c=right; c>=left && ptr; c--, ptr = ptr->next)
                    ans[bottom][c] = ptr->val;
                bottom--;
                direction = 3;
            }
            else {
                for(r=bottom; r>=top && ptr; r--, ptr = ptr->next)
                    ans[r][left] = ptr->val;
                left++;
                direction = 0;
            }
        }
        return ans;
    }
};