/*https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1*/

class Element implements Comparable<Element>
{
    int r, c, elem;
    Element(int r, int c, int elem)
    {
        this.r = r;
        this.c = c;
        this.elem = elem;
    }
    
    @Override
    public int compareTo(Element e)
    {
        return this.elem-e.elem;
    }
}

class Solution {
    int median(int matrix[][], int r, int c) {
        // code here
        PriorityQueue<Element> heap = new PriorityQueue<Element>();
        int i, j, elem1 = 0, elem2 = 0;
        for (i = 0; i < r; ++i)
            heap.add(new Element(i,0,matrix[i][0]));
        Element elem;
        int k = (r*c)/2;
        while (k-- >= 0)
        {
            elem2 = elem1;
            elem = heap.poll();
            elem1 = elem.elem;
            if (elem.c < c-1)
            {
                elem.c = elem.c+1;
                elem.elem = matrix[elem.r][elem.c];
                heap.add(elem);
            }
        }
        if ((r*c)%2 == 0) return (elem1+elem2)/2;
        return elem1;
    }
}