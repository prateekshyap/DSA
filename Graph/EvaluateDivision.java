/*https://leetcode.com/problems/evaluate-division/*/

// graph solution
class Destination implements Comparable<Destination>
{
    String node;
    double edgeValue;
    Destination(String n, double e)
    {
        node = n;
        edgeValue = e;
    }
    
    @Override
    public int compareTo(Destination d)
    {
        return 0;
    }
}

class Solution {
    boolean[] visited;
    LinkedHashMap<String,Integer> stringToNode;
    String[] nodeToString;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size(), i = 0, j = 0, nodeTag = 0, v;
        double[] result = new double[n];
        
        //store string to node number mappings in both the directions
        stringToNode = new LinkedHashMap<String,Integer>();
        for (List<String> equation : equations)
        {
            if (!stringToNode.containsKey(equation.get(0)))
                stringToNode.put(equation.get(0),nodeTag++);
            if (!stringToNode.containsKey(equation.get(1)))
                stringToNode.put(equation.get(1),nodeTag++);
        }
        v = stringToNode.size();
        nodeToString = new String[v];
        i = 0;
        for (Map.Entry elem : stringToNode.entrySet())
            nodeToString[i++] = (String)elem.getKey();
        
        //create the graph
        ArrayList<ArrayList<Destination>> graph = new ArrayList<ArrayList<Destination>>();
        for (i = 0; i < v; ++i)
            graph.add(new ArrayList<Destination>());
        
        i = 0;
        for (List<String> equation : equations)
        {
            graph.get(stringToNode.get(equation.get(0))).add(new Destination(equation.get(1),values[i]));
            graph.get(stringToNode.get(equation.get(1))).add(new Destination(equation.get(0),1/values[i]));
            ++i;
        }
        
        i = 0;
        for (List<String> query : queries) //for each query
        {
            visited = new boolean[v]; //reinitialize visited
            result[i] = -1;
            if (stringToNode.containsKey(query.get(0))) result[i] = dfs(graph,stringToNode.get(query.get(0)),query.get(1), 1); //call dfs if source exists
            if (result[i] == -1) //if source couldn't give the result
            {
                visited = new boolean[v]; //reinitialize visited
                if (stringToNode.containsKey(query.get(1))) result[i] = dfs(graph,stringToNode.get(query.get(1)),query.get(0), 1); //call dfs if destination exists
                result[i] = 1/result[i]; //invert it
            }
            ++i;
        }
        
        return result;
    }
    
    public double dfs(ArrayList<ArrayList<Destination>> graph, int source, String destination, double curr)
    {
        visited[source] = true; //mark source as visited
        double result = -1;
        if (nodeToString[source].equals(destination)) //if source is equal to destination
            return curr; //return the current multiplication value
        for (Destination adjacentNode : graph.get(source)) //for each adjacent node of the current source
        {
            if (!visited[(Integer)stringToNode.get(adjacentNode.node)]) //if not visited
                result = dfs(graph, (Integer)stringToNode.get(adjacentNode.node), destination, curr*adjacentNode.edgeValue); //call dfs for adjacent node
            if (result != -1) return result; //if result found, return
        }
        return -1;
    }
}


//efficient solution 1
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       
        Map<String, String> parent = new HashMap<>();  //<node, parent of the node>
        Map<String, Double> ratio = new HashMap<>();   //<node, node / parent>
        for (int i = 0; i < equations.size(); i++) {
            union(parent, ratio, equations.get(i).get(0),  equations.get(i).get(1), values[i]);
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String s1 = queries.get(i).get(0), s2 = queries.get(i).get(1);
            if (!parent.containsKey(s1) || !parent.containsKey(s2)
                || !find(parent, ratio, s1).equals(find(parent, ratio, s2))) {
                res[i] = -1.0;
            } else {
                res[i] = ratio.get(s1) / ratio.get(s2);
            }
        }
        return res;
    }
    
    private void union(Map<String, String> parent, Map<String, Double> ratio, String s1, String s2, double val) {
            if (!parent.containsKey(s1)) {
                parent.put(s1, s1);
                ratio.put(s1, 1.0);
            }
            if (!parent.containsKey(s2)) {
                parent.put(s2, s2);
                ratio.put(s2, 1.0);
            }
            String p1 = find(parent, ratio, s1);
            String p2 = find(parent, ratio, s2);
            parent.put(p1, p2);
            ratio.put(p1, val * ratio.get(s2) / ratio.get(s1));
    }
    
    private String find(Map<String, String> parent, Map<String, Double> ratio, String s) {
        if (s.equals(parent.get(s))) {
            return s;
        }
        String father = parent.get(s);
        String grandpa = find(parent, ratio, father);
        parent.put(s, grandpa);
        ratio.put(s, ratio.get(s) * ratio.get(father));
        return grandpa;
  

    }
}

// efficient solution 2
class Solution {
    class Node
    {
        String key;
        double val;
        Node(String key,double val)
        {
            this.key=key;
            this.val=val;
        }
    }
    public HashMap<String,List<Node>>buildgraph(List<List<String>>eq,double[]values)
    {
        HashMap<String,List<Node>>g=new HashMap<>();
        for(int i=0;i<values.length;i++)
        {
                String src = eq.get(i).get(0);
                String des = eq.get(i).get(1);
                g.putIfAbsent(src, new ArrayList());
                g.putIfAbsent(des, new ArrayList());
                g.get(src).add(new Node(des, values[i]));
                g.get(des).add(new Node(src, 1 / values[i]));
        }
        return g;
    }
    public double dfs(String s,String d,Set<String>visited,HashMap<String,List<Node>>g)
    {
         if (!(g.containsKey(s) && g.containsKey(d)))
                return -1.0;
            if (s.equals(d))
                return 1.0;
        visited.add(s);
        for(Node ng:g.get(s))
        {
            if(!visited.contains(ng.key))
            {
                double ans=dfs(ng.key,d,visited,g);
                if(ans!=-1.0)
                {
                    return ans*ng.val;
                }
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>>eq, double[] values, List<List<String>> queries)        {
        HashMap<String,List<Node>>g=buildgraph(eq,values);
        double[]result=new double[queries.size()];
        for(int i=0;i<queries.size();i++)
        {
           result[i]=dfs(queries.get(i).get(0),queries.get(i).get(1),new HashSet(),g);    
        }
        return result;
    }
}