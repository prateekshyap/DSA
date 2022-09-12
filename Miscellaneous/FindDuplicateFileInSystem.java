/*https://leetcode.com/problems/find-duplicate-file-in-system/*/

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for (String p : paths)
        {
            List<String> files = new ArrayList<String>(), contents = new ArrayList<String>();
            StringBuilder content = new StringBuilder(""), file = new StringBuilder(""), path = new StringBuilder("");
            int mode = 0;
            for (char ch: p.toCharArray())
            {
                if (ch == ' ')
                {
                    mode = 1;
                    continue;
                }
                else if (ch == '(')
                {
                    files.add(file.toString());
                    file = new StringBuilder("");
                    mode = 2;
                    continue;
                }
                else if (ch == ')')
                {
                    contents.add(content.toString());
                    content = new StringBuilder("");
                    mode = 3;
                    continue;
                }
                if (mode == 0)
                    path.append(ch);
                else if (mode == 1)
                    file.append(ch);
                else if (mode == 2)
                    content.append(ch);
            }
            for (int i = 0; i < contents.size(); ++i)
            {
                String f = files.get(i);
                String c = contents.get(i);
                if (!map.containsKey(c))
                    map.put(c,new ArrayList<String>());
                StringBuilder temp = new StringBuilder(path);
                temp.append("/");
                temp.append(f);
                map.get(c).add(temp.toString());
            }
        }
        for (Map.Entry entry : map.entrySet())
        {
            List<String> list = (List)entry.getValue();
            if (list.size() > 1)
            result.add(list);
        }
        return result;
    }
}

public class Solution {
    public List < List < String >> findDuplicate(String[] paths) {
        HashMap < String, List < String >> map = new HashMap < > ();
        for (String path: paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] name_cont = values[i].split("\\(");
                name_cont[1] = name_cont[1].replace(")", "");
                List < String > list = map.getOrDefault(name_cont[1], new ArrayList < String > ());
                list.add(values[0] + "/" + name_cont[0]);
                map.put(name_cont[1], list);
            }
        }
        List < List < String >> res = new ArrayList < > ();
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1)
                res.add(map.get(key));
        }
        return res;
    }
}