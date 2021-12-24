/*https://practice.geeksforgeeks.org/problems/unique-rows-in-boolean-matrix/1*/

class TrieNode
{
    TrieNode[] arr;
    boolean isEndOfRow;
    TrieNode()
    {
        arr = new TrieNode[2];
        isEndOfRow = false;
    }
}

class Trie
{
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public boolean isPresent(int[] row)
    {
        boolean result = true;
        TrieNode temp = root;
        for (int i = 0; i < row.length; ++i)
        {
            if (temp.arr[row[i]] == null)
            {
                result = false;
                temp.arr[row[i]] = new TrieNode();
            }
            temp = temp.arr[row[i]];
        }
        if (result && temp.isEndOfRow) result = true; else result = false;
        temp.isEndOfRow = true;
        return result;
    }
}

class GfG
{
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Trie trie = new Trie();
        trie.isPresent(a[0]);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < a[0].length; ++i)
            temp.add(a[0][i]);
        result.add(temp);
        for (int i = 1; i < a.length; ++i)
        {
            if (!trie.isPresent(a[i]))
            {
                temp = new ArrayList<Integer>();
                for (int j = 0; j < a[i].length; ++j)
                    temp.add(a[i][j]);
                result.add(temp);
            }
        }
        return result;
    }
}

/*Pratik's Code*/

class GfG
{
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        //add code here.
        TrieNode root = new TrieNode();
        ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<r;i++)
        {
            TrieNode temp = root;
            ArrayList<Integer> al = new ArrayList<Integer>();
            for(int j=0;j<c;j++)
            {
                al.add(a[i][j]);
                if(temp.arr[a[i][j]]==null)
                {
                    TrieNode newNode = new TrieNode();
                    temp.arr[a[i][j]] = newNode;
                }
                temp = temp.arr[a[i][j]];
            }
            if(temp.isEndOfRow==false)
            {
                aList.add(al);
                temp.isEndOfRow = true;
            }
        }
        return aList;
    }
}
class TrieNode
{
    TrieNode arr[] = new TrieNode[2];
    boolean isEndOfRow;
    TrieNode(){
        isEndOfRow = false;
    }
}