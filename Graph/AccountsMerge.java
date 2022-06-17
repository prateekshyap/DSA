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