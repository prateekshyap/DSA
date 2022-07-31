/*
https://leetcode.com/problems/rearrange-spaces-between-words/
1592. Rearrange Spaces Between Words

*/
class Solution {
public:
    /*
    string reorderSpaces(string text) {
        
        int size = text.size();
        int spaceCount=0, wordsCount=0;
        string buff;
        vector<string> words;
        
        for(char ch: text)
        {
            if(ch != ' ')
            {
                buff+=ch;
            }
            else
            {
                spaceCount++;
                if(buff != "")
                {
                    words.push_back(buff);
                    buff="";
                }
            }
        }
        if(buff != "")
        {
            words.push_back(buff);
            buff="";
        }
        wordsCount = words.size()-1;
        if(wordsCount==0)
        {
            string gap(spaceCount, ' ');
            return words[0]+gap;
        }
        int spaceGap = spaceCount / wordsCount;
        int lastGap = spaceCount % wordsCount;
        string ans;
        string gap(spaceGap, ' ');
        string lastG(lastGap, ' ');
        
        for(int i=0; i<words.size()-1; i++)
        {
            ans+= words[i] + gap;
        }
        
        return ans+words[wordsCount] + lastG;
    }//end
    */
    
     string reorderSpaces(string text) {
        
        int size = text.size();
        string buff;
        int cnt_spaces=0, cnt_words=0;
        vector<string> words;
        
        for(char ch: text)
        {
            if(ch!=' ')
                buff+=ch;
            else
            {
                if(buff!="")
                {
                    words.push_back(buff);
                    buff="";
                }
                cnt_spaces++;
            }
            
        }
         
        if(buff != "") //last word
        {
            words.push_back(buff);
            buff="";
        }
        
        int uniform_space=0, remainder_space = cnt_spaces;
        cnt_words = words.size()-1;
        if(cnt_words>0)
        {
            uniform_space = cnt_spaces / cnt_words;
            remainder_space = cnt_spaces % cnt_words;
        }
        
        string ans;
        string uniform_gap(uniform_space, ' ');
        string remainder_gap(remainder_space, ' ');
        
        for(int i=0; i<cnt_words; i++)
        {
            ans+= words[i] + uniform_gap;
        }
        
        return ans+words[cnt_words] + remainder_gap;
    }//end
};