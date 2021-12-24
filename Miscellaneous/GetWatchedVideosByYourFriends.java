/*https://leetcode.com/problems/get-watched-videos-by-your-friends/*/

class Info implements Comparable<Info>
{
    String movie;
    int frequency;
    Info(String s, int f)
    {
        movie = s;
        frequency = f;
    }
    @Override
    public int compareTo(Info i)
    {
        if (this.frequency < i.frequency) return -1;
        if (this.frequency > i.frequency) return 1;
        return this.movie.compareTo(i.movie);
    }
}

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<Integer>(); //for level order traversal
        boolean[] visited = new boolean[friends.length]; //for marking visits
        HashMap<String,Integer> hashTable = new HashMap<String,Integer>(); //for storing the frequencies
        
        //add the source and mark it visited
        queue.add(id);
        visited[id] = true;

        //run the loop for level-1 times
        while (level >= 1)
        {
            //get the number of ids for that level
            int len = queue.size();

            //for all the ids
            for (int i = 0; i < len; ++i)
            {
                //remove from the queue
                int currId = queue.remove();

                //for all friends of current id
                for (int j = 0; j < friends[currId].length; ++j)
                {
                    //if the friend is not visited
                    if (!visited[friends[currId][j]])
                    {
                        //add to queue and mark visited
                        queue.add(friends[currId][j]);
                        visited[friends[currId][j]] = true;
                    }
                }
            }

            //for next iteration
            --level;
        }

        /*At this point the queue contains all the friends at the given level*/

        //for all queue elements
        while (!queue.isEmpty())
        {
            //get the list of movies watched by the person
            List<String> videos = watchedVideos.get(queue.remove());

            //put the movie and its count in hashtable
            for (int i = 0; i < videos.size(); ++i)
                hashTable.put(videos.get(i),(hashTable.containsKey(videos.get(i)) ? hashTable.get(videos.get(i))+1 : 1));
        } 

        List<String> list = new ArrayList<String>(); //for storing the final results
        List<Info> temp = new ArrayList<Info>(); //for storing the movies along with the counts
        Iterator iterator = hashTable.entrySet().iterator(); //for iterating over the hashtable
        while (iterator.hasNext())
        {
            Map.Entry elem = (Map.Entry)iterator.next();
            //add the movie and its count to the list
            temp.add(new Info((String)elem.getKey(),(Integer)elem.getValue()));
        }

        //sort the list
        Collections.sort(temp);

        //add only movies from temp to list in the same sorted order
        for (int i = 0; i < temp.size(); ++i)
            list.add(temp.get(i).movie);
        return list;
    }
}