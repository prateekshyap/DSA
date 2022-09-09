/*https://leetcode.com/problems/subdomain-visit-count/*/

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> subdomainVisits = new ArrayList<String>();
        Map<String,Integer> subdomains = new HashMap<String,Integer>();
        for (String cpdomain : cpdomains)
        {
            StringBuilder subdomain = new StringBuilder("");
            int count = 0, dig = 0, len = cpdomain.length();
            while (dig < len)
            {
                char ch = cpdomain.charAt(dig);
                if (ch >= '0' && ch <= '9')
                    count = (count*10)+(ch-'0');
                else break;
                ++dig;
            }
            int chr = len-1;
            while (chr != dig)
            {
                char ch = cpdomain.charAt(chr);
                if (ch == '.')
                {
                    String stringSubdomain = subdomain.toString();
                    subdomains.put(stringSubdomain,subdomains.getOrDefault(stringSubdomain,0)+count);
                }
                subdomain.append(ch);
                --chr;
            }
            String stringSubdomain = subdomain.toString();
            subdomains.put(stringSubdomain,subdomains.getOrDefault(stringSubdomain,0)+count);
        }
        // System.out.println(subdomains);
        for (Map.Entry elem : subdomains.entrySet())
        {
            StringBuilder build = new StringBuilder("");
            build.append((String)elem.getKey());
            build.reverse();
            build.insert(0," ");
            build.insert(0,Integer.toString((Integer)elem.getValue()));
            subdomainVisits.add(build.toString());
        }
        return subdomainVisits;
    }
}