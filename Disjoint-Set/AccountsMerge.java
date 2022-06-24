/*https://leetcode.com/problems/accounts-merge/*/

// class Person implements Comparable<Person>
// {
//     String name;
//     HashSet<String> emails;
//     Person(List<String> acc)
//     {
//         this.name = acc.get(0);
//         this.emails = new HashSet<String>();
//         for (int i = 1; i < acc.size(); ++i) emails.add(acc.get(i));
//     }
    
//     @Override
//     public int compareTo(Person p)
//     {
//         return 0;
//     }
// }

// class Solution {
//     public List<List<String>> accountsMerge(List<List<String>> accounts) {
//         List<String> temp, newAccount;
//         int i, j;
//         for (List<String> account : accounts)
//         {
//             temp = new ArrayList<String>();
//             for (i = 1; i < account.size(); ++i)
//                 temp.add(account.get(i));
//             Collections.sort(temp);
//             newAccount = new ArrayList<String>();
//             for (String email : temp)
//                 newAccount.add(email);
//             newAccount.add(0,account.get(0));
//             account = newAccount;
//         }
//         Collections.sort(accounts, new Comparator<List<String>>(){
//             public int compare(List<String> list1, List<String> list2)
//             {
//                 int nameComparison = list1.get(0).compareTo(list2.get(0));
//                 if (nameComparison != 0) return nameComparison;
//                 int i = 1, j = 1;
//                 while (i < list1.size() && j < list2.size())
//                 {
//                     nameComparison = list1.get(i).compareTo(list2.get(j));
//                     if (nameComparison != 0) return nameComparison;
//                 }
//                 return i-j;
//             }
//         });
//         List<List<String>> result = new ArrayList<List<String>>();
//         int nodeTag = 0;
//         boolean tag = false, merged = false;
//         ArrayList<ArrayList<Person>> graph = new ArrayList<ArrayList<Person>>();
//         HashMap<String,Integer> sTN = new HashMap<String,Integer>();
//         HashMap<Integer,String> nTS = new HashMap<Integer,String>();
//         for (List<String> account : accounts)
//         {
//             if (sTN.containsKey(account.get(0)))
//             {
//                 tag = merged = false;
//                 for (Person adjacentNode :  graph.get((Integer)sTN.get(account.get(0))))
//                 {
//                     for (i = 1; i < account.size(); ++i)
//                     {
//                         if (adjacentNode.emails.contains(account.get(i)))
//                         {
//                             tag = merged = true;
//                             for (j = 1; j < account.size(); ++j)
//                                 adjacentNode.emails.add(account.get(j));
//                             break;
//                         }
//                     }
//                     if (merged) break;
//                 }
//                 if (!merged)
//                 {
//                     graph.get(sTN.get(account.get(0))).add(new Person(account));
//                 }
//             }
//             else
//             {
//                 sTN.put(account.get(0),nodeTag);
//                 nTS.put(nodeTag,account.get(0));
//                 graph.add(new ArrayList<Person>());
//                 graph.get(nodeTag).add(new Person(account));
//                 ++nodeTag;
//             }
//         }
//         i = 0;
//         for (ArrayList<Person> accountsList : graph)
//         {
//             for (Person p : accountsList)
//             {
//                 List<String> resultEntry = new ArrayList<String>();
//                 for (String email : p.emails)
//                     resultEntry.add(email);
//                 Collections.sort(resultEntry);
//                 resultEntry.add(0,nTS.get(i));
//                 result.add(resultEntry);
//             }
//             ++i;
//         }
        
//         return result;
//     }
// }

class Solution {
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();
    
    private void DFS(List<String> mergedAccount, String email) {
        visited.add(email);
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email);
        
        if (!adjacent.containsKey(email)) {
            return;
        }
        
        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                DFS(mergedAccount, neighbor);
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        int accountListSize = accountList.size();
        
        for (List<String> account : accountList) {
            int accountSize = account.size();
            
            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            String accountFirstEmail = account.get(1);
            for (int j = 2; j < accountSize; j++) {
                String accountEmail = account.get(j);
                
                if (!adjacent.containsKey(accountFirstEmail)) {
                    adjacent.put(accountFirstEmail, new ArrayList<String>());
                }
                adjacent.get(accountFirstEmail).add(accountEmail);
                
                if (!adjacent.containsKey(accountEmail)) {
                    adjacent.put(accountEmail, new ArrayList<String>());
                }
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }
        
        // Traverse over all th accounts to store components
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accountList) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);
            
            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);
                
                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size())); 
                mergedAccounts.add(mergedAccount);
            }
        }
        
        return mergedAccounts;
    }
}

class Solution {
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        int[] parents = new int[accounts.size()];
        //intialize the parent and the result list
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
            result.add(new ArrayList<>());
        }
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                //check if the email exists
                if(map.containsKey(email)){
                    int parentId = map.get(email);
                    //now if the email is present
                    //we need to see if this group is a parent of itself or not
                    if(parents[i] != i && parentId != parents[i]){
                        //if the parent was already assigned and some one trying to assign a new parent
                        //then find the current parent
                        int p1 = find(parents, i);
                        //then find the parent id that one was trying to update
                        int p2 = find(parents, parentId);
                        //and then union/merge the root parent
                        //by making any root parent id as a parent of another root parent.
                        parents[p2] = p1;
                    }else{
                        //if the group is the parent of itself mean
                        //that is not already has a parent
                        //so lets assign parent for the first time
                        parents[i] = find(parents, parentId);
                    }  
                }else{
                    //if email does not exists add it to the map with its group idx
                    map.put(email, i);
                }
            }
        }
        
        //finally lets merge actually in the list previously we just merged in the parent array
        for(int i = 0; i < accounts.size(); i++){
            List<String> acc = accounts.get(i);
            int parentId = find(parents, i);
            //check if its a parent of itself i.e. its a root
            if(parentId == i){
                //remove the name and add other
                List<String> emails = acc.subList(1, acc.size());
                //possibly the root is 3, BUT as we linearly iterating it 0 would also be the child of 3 and would have added to 3. so get by parent id and add.
                result.get(parentId).addAll(emails);
            }else{
                //its not the root so get it parent group list and then add
                List<String> groupEmails = acc.subList(1, acc.size());
                result.get(parentId).addAll(groupEmails);
            }
        }
        
        List<List<String>> finalResult = new ArrayList<>();
        for(int i = 0; i < result.size(); i++){
            List<String> res = result.get(i);
            //is some accounts are merged then there current position will be empty
            if(res.isEmpty()) continue;
            res = res.stream().distinct().sorted().collect(Collectors.toList());
            List<String> grouped = new ArrayList<>();
            //get the name
            //sort the result
            grouped.add(accounts.get(i).get(0));
            grouped.addAll(res);
            //and add
            finalResult.add(grouped);
        }
        //done!
        return finalResult;
    }
    
    private int find(int[] parent, int id){
        if(id == parent[id]) return id;
        return parent[id] = find(parent, parent[id]);
    }
}