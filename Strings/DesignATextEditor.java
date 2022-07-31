/*https://leetcode.com/problems/design-a-text-editor/*/

class TextEditor {
    StringBuilder text;
    int cursorPosition;
    public TextEditor() {
        text = new StringBuilder(20);
        cursorPosition = 0;
    }
    
    public void addText(String text) {
        this.text.insert(cursorPosition,text);
        cursorPosition += text.length();
    }
    
    public int deleteText(int k) {
        int count = text.substring(Math.max(cursorPosition-k,0),cursorPosition).length();
        text.replace(Math.max(cursorPosition-k,0),cursorPosition,"");
        cursorPosition -= count;
        return count;
    }
    
    public String cursorLeft(int k) {
        int newPos = cursorPosition-k;
        cursorPosition -= Math.min(k,cursorPosition);
        StringBuilder returnText = new StringBuilder("");
        int index = cursorPosition-1;
        while (index >= 0 && index >= cursorPosition-10)
            returnText.insert(0,text.charAt(index--));
        return returnText.toString();
    }
    
    public String cursorRight(int k) {
        int newPos = cursorPosition+k;
        cursorPosition += Math.min(k,text.length()-cursorPosition);
        StringBuilder returnText = new StringBuilder("");
        int index = cursorPosition-1;
        while (index >= 0 && index >= cursorPosition-10)
            returnText.insert(0,text.charAt(index--));
        return returnText.toString();
    }
}

class Node {
    Node prev;
    char ch;
    Node next;
    Node(char ch)
    {
        this.ch = ch;
    }
}

class LList {
    Node head, tail, cursor;
    LList() {
        cursor = new Node('\0');
        head = cursor;
        tail = cursor;
    }
    public void add(char[] text)
    {
        for (int i = 0; i < text.length; ++i)
        {
            Node newNode = new Node(text[i]);
            newNode.prev = cursor.prev;
            newNode.next = cursor;
            if (newNode.prev != null) newNode.prev.next = newNode;
            if (newNode.next != null) newNode.next.prev = newNode;
            if (head == cursor) head = newNode;
        }
    }
    public int delete(int k)
    {
        Node temp;
        int count = 0;
        while (cursor.prev != null && k > 0)
        {
            ++count; --k;
            temp = cursor.prev;
            if (temp == head) head = cursor;
            if (temp.prev != null) temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        return count;
    }
    public String move(int k, int dir)
    {
        int copy = k;
        StringBuilder text = new StringBuilder("");
        if (dir == 0) //left
        {
            while (cursor != head && k > 0)
            {
                --k;
                cursor = cursor.prev;
            }
        }
        else //right
        {
            while (cursor != tail && k > 0)
            {
                --k;
                cursor = cursor.next;
            }
        }
        Node temp = cursor.prev; k = 10;
        while (temp != null && k > 0)
        {
            --k;
            text.insert(0,temp.ch);
            temp = temp.prev;
        }
        return text.toString();
    }
}
    
class TextEditor {
    LList text;
    public TextEditor() {
        text = new LList();
    }
    
    public void addText(String text) {
        this.text.add(text.toCharArray());
    }
    
    public int deleteText(int k) {
        return text.delete(k);
    }
    
    public String cursorLeft(int k) {
        return text.move(k,0);
    }
    
    public String cursorRight(int k) {
        return text.move(k,1);
    }
}

class TextEditor {

    class Node {
        Node prev, next;
        String s;
        public Node(String s) {
            this.s = s;
        }
    }
    int offset;
    Node cur;
    char[] buf;
    public TextEditor() {
        cur = new Node("");
        buf = new char[10];
        offset = 0;
    }
    
    public void addText(String text) {
        if (cur.prev == null) {
            Node p = new Node(text);
            if (cur.next != null) {
                p.next = cur.next;
                cur.next.prev = p;
            }
            cur.prev = p;
        }else {
            Node node = new Node(text);
            node.prev = cur.prev;
            node.next = cur.next;
            cur.prev.next = node;
            if (cur.next != null)
                cur.next.prev = node;
            
            cur.prev = node;
        }
    }
    
    public int deleteText(int k) {
        int del = 0;
        while (k > 0) {
            if (cur.prev == null)
                break;
            
            int len = cur.prev.s.length();
            if (len <= k) {
                k -= len;
                cur.prev = cur.prev.prev;
                del += len;
                if (cur.prev != null)
                    cur.prev.next = cur.next;
                if (cur.next != null)
                    cur.next.prev = cur.prev;
            }else {
                cur.prev.s = cur.prev.s.substring(0, len - k);
                del += k;
                k = 0;
                break;
            }
        }
        return del;
    }
    
    public String cursorLeft(int k) {
        while (k > 0) {
            if (cur.prev == null)
                return "";
            
            int len = cur.prev.s.length();
            if (len <= k) {
                k -= len;
                cur.next = cur.prev;
                cur.prev = cur.prev.prev;
                
            }else {
                Node node = new Node(cur.prev.s.substring(len - k, len));
                node.prev = cur.prev;
                node.next = cur.next;
                if (cur.next != null)
                    cur.next.prev = node;
                cur.prev.next = node;
                cur.prev.s = cur.prev.s.substring(0, len - k);
                cur.next = node;
                k=0;
            }
        }
        
        return left();
    }
    
    public String cursorRight(int k) {
        while (k > 0) {
            if (cur.next == null)
                break;
            
            int len = cur.next.s.length();
            if (len <= k) {
                k -= len;
                cur.prev = cur.next;
                cur.next = cur.next.next;                
            }else {
                Node node = new Node(cur.next.s.substring(0, k));
                node.prev = cur.prev;
                node.next = cur.next;
                cur.next.prev = node;
                if (cur.prev != null)
                    cur.prev.next = node;
                cur.next.s = cur.next.s.substring(k, len);
                cur.prev = node;
                k = 0;
            }
        }
        
        return left();
    }
    
    private String left() {
        if (cur.prev == null) return "";
        
        int k = 10;        
        int lo = 9;
        Node p = cur.prev;
        Node nx = cur.next;
        
        Node tmp = cur;
        
        while (k > 0) {
            if (tmp.prev == null)
                break;
            
            int len = tmp.prev.s.length();
            if (len >= k) {
                cur.prev = p;
                cur.next = nx;
                return tmp.prev.s.substring(len - k, len) + new String(buf, lo+1, 9-lo);
            }else {
                for (int j = 0; j < len; j++, lo--) {
                    buf[lo] = tmp.prev.s.charAt(len - 1 - j);
                }
                k -= len;
                tmp = tmp.prev;
            }
        }
        
        cur.prev = p;
        cur.next = nx;
        return new String(buf, lo+1, 9-lo);
    }
}
