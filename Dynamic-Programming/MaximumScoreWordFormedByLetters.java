/*https://leetcode.com/problems/maximum-score-words-formed-by-letters/*/


/*Greedy Approach that does not work for 2nd testcase*/
class Word implements Comparable<Word>
{
    int[] hash;
    int score;
    Word(String word, int s)
    {
        hash = new int[26];
        score = s;
        for (char ch : word.toCharArray())
            ++hash[ch-'a'];
    }
    
    @Override
    public int compareTo(Word w)
    {
        return w.score-this.score; 
    }
}

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int W = words.length, L = letters.length, S = score.length, i, finalScore = 0;
        int[] wordScores = new int[W];
        for (i = 0; i < W; ++i)
            for (char ch : words[i].toCharArray())
                wordScores[i] += score[ch-'a'];
        int[] freq = new int[S];
        for (char letter : letters) ++freq[letter-'a'];
        int[] newFreq, wordFreq;
        PriorityQueue<Word> wordExtractor = new PriorityQueue<Word>();
        for (i = 0; i < W; ++i)
            wordExtractor.add(new Word(words[i],wordScores[i]));
        Word word;
        while (!wordExtractor.isEmpty())
        {
            word = wordExtractor.poll();
            newFreq = freq.clone();
            for (i = 0; i < S; ++i)
            {
                if (word.hash[i] <= newFreq[i])
                    newFreq[i] -= word.hash[i];
                else
                {
                    newFreq = null;
                    break;
                }
            }
            if (newFreq != null)
            {
                freq = newFreq;
                finalScore += word.score;
            }
        }
        return finalScore;
    }
}

/*DP equivalent approach*/
class Solution
{
    int max, W;
    public int maxScoreWords(String[] words, char[] letters, int[] score)
    {
        max = 0; W = words.length;
        int L = letters.length, S = score.length, i, finalScore = 0;
        int[] wordScores = new int[W];
        for (i = 0; i < W; ++i)
            for (char ch : words[i].toCharArray())
                wordScores[i] += score[ch-'a'];
        int[] freq = new int[S];
        for (char letter : letters) ++freq[letter-'a'];
        recur(words, wordScores, 0, freq, 0);
        return max;
    }
    public void recur(String[] words, int[] scores, int index, int[] freq, int score)
    {
        if (index == W)
        {
            if (score > max) max = score;
            return;
        }
        int[] newFreq = freq.clone();
        // int[] hash = new int[26];
        // for (char ch : words[index].toCharArray()) ++hash[ch-'a'];
        // for (int i = 0; i < 26; ++i)
        // {
        //     if (newFreq[i] >= hash[i]) newFreq[i] -= hash[i];
        //     else
        //     {
        //         newFreq = null;
        //         break;
        //     }
        // }
        for (char ch : words[index].toCharArray())
        {
            if (newFreq[ch-'a'] > 0) --newFreq[ch-'a'];
            else
            {
                newFreq = null;
                break;
            }
        }
        if (newFreq != null) recur(words, scores, index+1, newFreq, score+scores[index]);
        recur(words, scores, index+1, freq, score);
    }
}