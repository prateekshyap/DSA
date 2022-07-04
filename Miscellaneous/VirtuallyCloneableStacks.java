/*https://binarysearch.com/problems/Virtually-Cloneable-Stacks*/

import java.util.*;

class VirtuallyCloneableStacks {
    ArrayList<Integer> sizes;
    public VirtuallyCloneableStacks() {
        sizes = new ArrayList<Integer>();
        sizes.add(0);
    }

    public void copyPush(int i) {
        sizes.add(sizes.get(i)+1);
    }

    public void copyPop(int i) {
        sizes.add(sizes.get(i)-1);
    }

    public int size(int i) {
        return (Integer)sizes.get(i);
    }
}

import java.util.*;

class VirtuallyCloneableStacks {
    int[] arr;
    int top;
    public VirtuallyCloneableStacks() {
        arr = new int[8];
        top = 0;
    }

    public void copyPush(int i) {
        if (top == arr.length-1) resize();
        arr[++top] = arr[i]+1;
    }

    public void copyPop(int i) {
        if (top == arr.length-1) resize();
        arr[++top] = arr[i]-1;
    }

    public int size(int i) {
        return arr[i];
    }

    private void resize()
    {
        int[] newArr = new int[arr.length*2];
        for (int i = 0; i < arr.length; ++i)
            newArr[i] = arr[i];
        arr = newArr;
    }
}