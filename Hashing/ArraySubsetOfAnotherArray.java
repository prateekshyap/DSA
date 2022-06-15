/*https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1/*/

class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        HashSet<Long> set = new HashSet<Long>();
        for (long element : a1) set.add(element);
        for (long element : a2) if (!set.contains(element)) return "No";
        return "Yes";
    }
}