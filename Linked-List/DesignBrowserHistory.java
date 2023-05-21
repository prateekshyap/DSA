/*https://leetcode.com/problems/design-browser-history/*/

class BrowserHistory {
    Webpage browserStart, browserEnd;
    public BrowserHistory(String homepage) {
        browserStart = browserEnd = new Webpage(homepage);
    }
    
    public void visit(String url) {
        browserEnd.next = new Webpage(url);
        browserEnd.next.prev = browserEnd;
        browserEnd = browserEnd.next;
    }
    
    public String back(int steps) {
        while (steps-- > 0 && browserEnd != browserStart)
            browserEnd = browserEnd.prev;
        return browserEnd.address;
    }
    
    public String forward(int steps) {
        while (steps-- > 0 && browserEnd.next != null)
            browserEnd = browserEnd.next;
        return browserEnd.address;
    }

    class Webpage
    {
        Webpage prev;
        String address;
        Webpage next;
        Webpage(String address)
        {
            this.address = address;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */