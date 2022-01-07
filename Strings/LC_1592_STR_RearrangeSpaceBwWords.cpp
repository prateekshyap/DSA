/* https://leetcode.com/problems/rearrange-spaces-between-words/
 * You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.
 */
 
 class Solution {
public:
    string reorderSpaces(string text) {
        int cnt_words=0;
        int cnt_spaces=0;
        int uniform_space =0, remainder_space=0;
        vector<string> words;
        
        // counting words and spaces
//         for(int c=0; c<text.size(); c++){
//             if(text[c] == ' ') cnt_spaces++;
//             else
//             {
//                 string temp;
//                 for(; c<text.size(); c++)
//                     if(text[c] != ' ')temp = temp+text[c];
//                     else {
//                         cnt_spaces++; break;
//                     }
//                 words.push_back(temp);
//             }
            
//         }//for c
        
//         // couting space between words and at the last
//         if(words.size() == 1) {
//             uniform_space=0, 
//             remainder_space=cnt_spaces;
//         }
//         else
//         {
//             uniform_space = cnt_spaces/(words.size()-1);
//             remainder_space=cnt_spaces%(words.size()-1);
//         }
        
//         //making final string
//         string ans_str=words[0];
//         for(int w=1; w<words.size(); w++){
//             for(int s=1; s<=uniform_space; s++) ans_str.push_back(' ');
//             ans_str +=words[w];            
//         }
//         for(int s=1; s<=remainder_space; s++) ans_str.push_back(' ');
        
//         return ans_str;
        
        // Another Approach
        int words_len=0;
        stringstream ss(text);
        string w;
        while(ss>>w){
            cnt_words++;
            words_len += size(w);
        }
        cnt_spaces = size(text) - words_len;
        uniform_space = cnt_words!=1 ? cnt_spaces/(cnt_words-1) : 0;
        string ans;
        for(stringstream s(text); s>>w; cnt_spaces-=uniform_space)
            ans.append(w).append(--cnt_words?uniform_space:cnt_spaces,' ');
        return ans;
    }//reorderSpaces
    
    
};