/*https://leetcode.com/problems/sort-the-people/*/

class Person
{
    String name;
    int height;
    Person(String n, int h)
    {
        name = n;
        height = h;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];
        for (int i = 0; i < n; ++i)
            people[i] = new Person(names[i],heights[i]);
        Arrays.sort(people,(a,b)->(b.height-a.height));
        String[] newNames = new String[n];
        for (int i = 0; i < n; ++i)
            newNames[i] = people[i].name;
        return newNames;
    }
}