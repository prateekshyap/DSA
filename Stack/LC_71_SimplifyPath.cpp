/*
https://leetcode.com/problems/simplify-path/
71. Simplify Path

*/
class Solution {
public:
    string simplifyPath_(string path) {
        
        stack<string> st;
        string ans, temp;
        
        for(int i=0; i<path.size(); i++)
        {
            if(path[i] == '/')
                continue;
            temp="";
            while(i<path.size() && path[i] != '/')
            {
                temp+=path[i];
                i++;
            }
            
            if(temp==".")
                continue;
            else if (temp == "..")
            {
                if(!st.empty())
                    st.pop();
            }
            else 
                st.push(temp);
        }
        
        while(!st.empty())
        {
            ans = "/" + st.top() + ans;
            st.pop();
        }
        if(ans.empty()) return "/";
        
        return ans;
    }//end
    
    string simplifyPath(string path) {
        
        stack<string> st;
        string ans, temp;
        
        stringstream streamdata(path);
        
        while(getline(streamdata, temp, '/'))
        {
            // cout<<x<<" ";
            if(temp=="" or temp == ".")
                continue; // "//" or /./
            
            if(temp == "..")
            {
                if(!st.empty())
                    st.pop();
            }
            else 
                st.push(temp);
        }    
        
        while(!st.empty())
        {
            ans = "/" + st.top() + ans;
            st.pop();
        }
        
        if(ans.empty()) return "/";
        
        return ans;
    }
};